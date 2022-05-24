package com.example.app.controller;

import com.example.app.model.entity.Company;
import com.example.app.model.params.IdParam;
import com.example.app.model.vo.DataResult;
import com.example.app.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 幕冬
 * @since 2022年05月24日
 */
@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/get")
    public DataResult<Company> get(@RequestBody IdParam param) {
        return DataResult.ok(companyService.getById(param.getId()));
    }

    @PostMapping("/list")
    public DataResult<List<Company>> list() {
        return DataResult.ok(companyService.list());
    }

    @PostMapping("/insert")
    public DataResult<Boolean> insert(@RequestBody Company company) {
        return DataResult.ok(companyService.save(company));
    }

    @PostMapping("/update")
    public DataResult<Boolean> update(@RequestBody Company company) {
        return DataResult.ok(companyService.updateById(company));
    }

    @PostMapping("/delete")
    public DataResult<Boolean> delete(@RequestBody IdParam param) {
        return DataResult.ok(companyService.removeById(param.getId()));
    }

}
