package com.board.util;

import com.board.constant.Method;
import com.board.paging.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class UiUtils {

    public String showMessageWithRedirect(//사용자에게 전달할 메세지를 의미함
                                          @RequestParam(value = "message", required = false) String message,
                                          @RequestParam(value = "redirectUri", required = false) String redirectUri,
                                          //앞에서 추가한 Method Enum 클래스에 선언한 HTTP 요청 메서드입니다.
                                          @RequestParam(value = "method", required = false) Method method,
                                          @RequestParam(value = "params", required = false) Map<String, Object> params, Model model) {

        model.addAttribute("message", message);
        model.addAttribute("redirectUri", redirectUri);
        model.addAttribute("method", method);
        model.addAttribute("params", params);

        return "utils/message-redirect";
    }

    public Map<String, Object> getPagingParams(Criteria criteria) {

        Map<String, Object> params = new LinkedHashMap<>();
        params.put("currentPageNo", criteria.getCurrentPageNo());
        params.put("recordsPerPage", criteria.getRecordsPerPage());
        params.put("pageSize", criteria.getPageSize());
        params.put("searchType", criteria.getSearchType());
        params.put("searchKeyword", criteria.getSearchKeyword());

        return params;
    }

}