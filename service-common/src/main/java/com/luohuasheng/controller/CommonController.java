package com.luohuasheng.controller;

import com.google.common.collect.Maps;
import com.luohuasheng.dto.ServletInfoDto;
import com.luohuasheng.dto.SystemInfoDto;
import com.luohuasheng.dto.VersionDto;
import com.luohuasheng.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author panda
 */
@Api(description = "公共参数")
@RequestMapping(value = "/common")
public class CommonController {
    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private Integer port;

    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private ServletContext servletContext;

    @ApiOperation(value = "获取客户端信息", notes = "注意问题点")
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    @ResponseBody
    public List<ServiceInstance> clients() {
        List<ServiceInstance> serviceInstances = new ArrayList<>();
        for (String serviceId : client.getServices()) {
            serviceInstances.addAll(client.getInstances(serviceId));
        }

        return serviceInstances;
    }

    @ApiOperation(value = "获取编码描述", notes = "根据编码获取编码对应的描述值")
    @RequestMapping(value = "/language", method = RequestMethod.GET)
    @ResponseBody
    public String language(@ApiParam(value = "编码", required = true) @RequestParam String code) {
        throw BaseException.create(code, "其他");
    }


    @RequestMapping(value = "/whole", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public Map<String, Object> whole() {
        Map<String, Object> map = Maps.newConcurrentMap();
        map.put("system", systemInfo());
        map.put("version", version());
        map.put("servlet", servlet());
        return map;
    }

    @RequestMapping(value = "/system", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public SystemInfoDto systemInfo() {
        return new SystemInfoDto();
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public VersionDto version() {
        return VersionDto.getInstance();
    }

    @RequestMapping(value = "/servlet", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody

    public ServletInfoDto servlet() {
        ServletInfoDto servletInfoDto = new ServletInfoDto(servletContext);
        servletInfoDto.setServerPort(port);
        servletInfoDto.setName(name);
        return servletInfoDto;
    }
}
