package tw.idv.cha102.g7.common.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tw.idv.cha102.g7.common.filter.MyFilter;

@Configuration
public class UandmeConfiguration {

    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        //要通過此filter的入口
        bean.addUrlPatterns("/*");
        bean.setName("myFilter");

        //設定此filter再filterChain的執行順序 數字越小 越早擷取請求 越晚擷取回應
        bean.setOrder(0);
        System.out.println("FILTER");


        return bean;
    }

}
