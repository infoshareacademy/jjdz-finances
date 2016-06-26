package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.dto.LstList;
import com.infoshareacademy.finances.entity.PlanCreationDto;
import com.infoshareacademy.finances.entity.UserInfo;
import com.infoshareacademy.finances.entity.UserInfoEntity;
import com.infoshareacademy.finances.repository.FundsRepository;
import com.infoshareacademy.finances.repository.PlansRepository;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.service.AssetService;
import com.infoshareacademy.finances.service.PlanDaoService;
import com.infoshareacademy.finances.service.UserSessionData;

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

@WebServlet(name = "CrudServlet", urlPatterns = "/createEdit")
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String quantity = request.getParameter("quantity");
        if ( quantity != null && !quantity.equals("")){
            System.out.println(request.getParameter("selectAsset"));
            System.out.println(request.getParameter("quantity"));
            System.out.println(request.getParameter("action"));
            System.out.println(request.getParameter("date"));
            Long id = userSessionData.getUserId();
            UserInfoEntity userInfoEntity = userInfoRepository.findUserById(id);

            List<LstList> fundList = assetService.returnAllFunds();
            request.setAttribute("fundList", fundList);
            PlanCreationDto planCreationDto = new PlanCreationDto();
            planCreationDto.setQuantity(Integer.parseInt(quantity));
            planCreationDto.setPlanActionType(PlanCreationDto.PlanActionType.valueOf(request.getParameter("action")));
            planCreationDto.setAssetEntity(fundsRepository.findRandomAsset(request.getParameter("selectAsset")));
//        planCreationDto.setActionTime(ZonedDateTime.now());
            try {
                Date dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("date"));
                ZonedDateTime actionTime = ZonedDateTime.ofInstant(dateFormat.toInstant(), ZoneId.systemDefault());
                planCreationDto.setActionTime(actionTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            planCreationDto.setUserInfoEntity(userInfoEntity);
            planDaoService.createOrUpdate(planCreationDto);

        }

        UserInfo userInfo = userSessionData.getUserInfo();
        Long userId = userInfoRepository.findUserId(userInfo.getMail());
        List<PlanCreationDto> allPlans = plansRepository.findAllPlans(userId);
        List<LstList> fundList = assetService.returnAllFunds();
        request.setAttribute("fundList", fundList);

        request.getRequestDispatcher("createOrEditPlan.jsp").forward(request, response);
    }

}
