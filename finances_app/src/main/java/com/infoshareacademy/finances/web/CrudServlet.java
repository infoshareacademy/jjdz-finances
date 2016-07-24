package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.entity.PlanActionType;
import com.infoshareacademy.finances.entity.PlanCreationDto;
import com.infoshareacademy.finances.entity.UserInfo;
import com.infoshareacademy.finances.entity.UserInfoEntity;
import com.infoshareacademy.finances.model.dto.LstList;
import com.infoshareacademy.finances.repository.FundsRepository;
import com.infoshareacademy.finances.repository.PlansRepository;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.service.AssetService;
import com.infoshareacademy.finances.service.PlanDaoService;
import com.infoshareacademy.finances.service.UserSessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CrudServlet", urlPatterns = "/crudServlet")
public class CrudServlet extends HttpServlet {

    @EJB
    FundsRepository fundsRepository;

    @EJB
    PlansRepository plansRepository;

    @EJB
    UserInfoRepository userInfoRepository;

    @Inject
    UserSessionData userSessionData;

    @EJB
    PlanDaoService planDaoService;

    @EJB
    AssetService assetService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CrudServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String quantity = request.getParameter("quantity");
        boolean validToken = request.getParameter("token").equals(userSessionData.getCsrf());

        if (quantity != null && !quantity.equals("") && validToken){

            Long id = userSessionData.getUserId();
            UserInfoEntity userInfoEntity = userInfoRepository.findUserById(id);

            PlanCreationDto planCreationDto;

            List<LstList> fundList = assetService.returnAllFunds();
            request.setAttribute("fundList", fundList);
            if (request.getAttribute("PlanId") != null) {
                LOGGER.info("############ plan id:{}", request.getAttribute("PlanId"));
                Long existingPlanId = Long.parseLong(String.valueOf(request.getAttribute("PlanId")));
                planCreationDto = planDaoService.find(existingPlanId);

                request.setAttribute("assetName", planCreationDto.getAssetEntity().getAsset().getName());

                LOGGER.info("############ existing PlanCreationDto:{}", planCreationDto.toString());
            } else {
                planCreationDto = new PlanCreationDto();
                LOGGER.info("############# no plan id, creating new");
            }

            planCreationDto.setQuantity(Integer.parseInt(quantity));
            planCreationDto.setPlanActionType(PlanActionType.valueOf(request.getParameter("action")));
            planCreationDto.setAssetEntity(fundsRepository.findRandomAsset(request.getParameter("selectAsset")));
            try {
                Date dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm a").parse(request.getParameter("date"));
                ZonedDateTime actionTime = ZonedDateTime.ofInstant(dateFormat.toInstant(), ZoneId.systemDefault());
                planCreationDto.setActionTime(actionTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String planId = request.getParameter("PlanId");
            if (planId != null && !quantity.equals("")) {
                planCreationDto.setId(Long.parseLong(planId));
            }
            planCreationDto.setUserInfoEntity(userInfoEntity);
            LOGGER.info("############ planCreationDto to save:{}", planCreationDto);
            planDaoService.createOrUpdate(planCreationDto);

        } else if (quantity != null && !quantity.equals("") && !validToken){
            response.sendRedirect("/main?action=logoutSelected");

        }

        UserInfo userInfo = userSessionData.getUserInfo();
        String token = UUID.randomUUID().toString().toUpperCase();
        userSessionData.setCsrf(token);
        request.setAttribute("token", token);
        Long userId = userInfoRepository.findUserId(userInfo.getMail());
        List<PlanCreationDto> allPlans = plansRepository.findAllPlans(userId);
        List<LstList> fundList = assetService.returnAllFunds();
        request.setAttribute("fundList", fundList);

        LOGGER.info("############ D ID ! :{}", request.getAttribute("PlanId"));

        request.getRequestDispatcher("createOrEditPlan.jsp").forward(request, response);
    }


}
