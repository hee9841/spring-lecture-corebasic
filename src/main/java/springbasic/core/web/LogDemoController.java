package springbasic.core.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springbasic.core.common.MyLogger;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    // myLogger를 주입받는게 아니라 myLogger를 찾을 수 있는 룩업을 주입 받게 됨
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        //동시에 여러 요청이 언다고 해도
        //요청마다 각각 객체를 따로 관리 해줌
//        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        Thread.sleep(1000);

        logDemoService.logic("testId");

        return "OK";

    }
}
