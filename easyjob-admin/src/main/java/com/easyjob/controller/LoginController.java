package com.easyjob.controller;

import com.easyjob.annotation.GlobalInterceptor;
import com.easyjob.annotation.VerifyParam;
import com.easyjob.entity.dto.CreateImageCode; // 引入创建验证码的包
import com.easyjob.entity.constants.Constants;

import com.easyjob.entity.dto.SessionUserAdminDto;
import com.easyjob.entity.enums.ResponseCodeEnum;
import com.easyjob.entity.enums.SysAccountStatusEnum;
import com.easyjob.entity.enums.VerifyRegexEnum;
import com.easyjob.entity.po.SysAccount;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.exception.BusinessException;
import com.easyjob.service.SysAccountService;
import com.easyjob.utils.StringTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.IOException;

@RestController
public class LoginController extends ABaseController {
    @Resource
    private SysAccountService sysAccountService;

    // 验证码
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session) throws IOException {
        CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String code = vCode.getCode();
        session.setAttribute(Constants.CHECK_CODE_KEY, code); // 图片验证码放入session
        vCode.write(response.getOutputStream());
    }

    /***
     * 登录
     * @param session
     * @param phone
     * @param password
     * @param checkCode
     * @return
     */
    @RequestMapping("/login")
    @GlobalInterceptor(checkLogin = false)
    public ResponseVO login(HttpSession session,
                            @VerifyParam(regex = VerifyRegexEnum.PHONE) String phone,
                            @VerifyParam(required = true) String password,
                            @VerifyParam(required = true) String checkCode) {
        if (!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY))) {
            throw new BusinessException("图片验证码错误！");
        }
        SessionUserAdminDto userAdminDto = sysAccountService.login(phone, password);
        session.setAttribute(Constants.SESSION_KEY, userAdminDto);
        return getSuccessResponseVO(userAdminDto);
    }

    /***
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    @GlobalInterceptor(checkLogin = false)
    public ResponseVO logout(HttpSession session) {
        session.invalidate();
        return getSuccessResponseVO(null);
    }

    /***
     * 修改密码
     * @param session
     * @return
     */
    @RequestMapping("/updateMyPwd")
    @GlobalInterceptor
    public ResponseVO updateMyPwd(HttpSession session,
                                @VerifyParam(required = true, regex = VerifyRegexEnum.PASSWORD) String password) {
        SessionUserAdminDto userAdminDto = getUserAdminFromSession(session);
        SysAccount sysAccount = new SysAccount();
        sysAccount.setPassword(StringTools.encodeByMD5(password));
        sysAccountService.updateSysAccountByUserId(sysAccount, userAdminDto.getUserid());
        return getSuccessResponseVO(null);
    }
}
