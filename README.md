# Spring-cloud 微服务
spring-cloud 微服务组件demo

<table>
    <thead>
        <tr>
            <td>工程名</td>  
            <td>描述</td>  
            <td>端口</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>eureka-server</td>  
            <td>服务发现与注册中心</td>  
            <td>7001</td>
        </tr>
        <tr>
            <td>zuul-server</td>  
            <td>动态路由器</td>  
            <td>7002</td>
        </tr>
        <tr>
            <td>service-demo</td>  
            <td>demo服务，实现两个数相加，用来测试服务间调用与路由</td>  
            <td>9001/9002</td>
        </tr>
    </tbody>
</table>
