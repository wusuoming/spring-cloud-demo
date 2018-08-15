# micro-service
spring-cloud 微服务组件demo

<table>
<tbody><tr>
<td>工程名</td>  <td>描述</td>  <td>端口</td>
</tr>
<tr>
<td>eureka-server</td>  <td>服务发现与注册中心</td>  <td>7071</td>
</tr>
<tr>
<td>ribbon</td>  <td>负载均衡器</td>  <td>7072</td>
</tr>
<tr>
<td>zuul</td>  <td>动态路由器</td>  <td>7073</td>
</tr>
<tr>
<td>service-demo1</td>  <td>demo1服务，实现两个数相加，用来测试服务间调用与路由</td>  <td>7074</td>
</tr>
<tr>
<td>service-demo2</td>  <td>demo2服务，实现两个数相减，用来测试服务间调用与路由</td>  <td>7078</td>
</tr>
</tbody></table>
