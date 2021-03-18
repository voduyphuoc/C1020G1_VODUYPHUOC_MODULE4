package com.example.entity.contract;


import com.example.entity.customer.Customer;
import com.example.entity.employee.Employee;
import com.example.entity.service.Services;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "contract")
public class Contract {
    @Id
    @Pattern(regexp = "^(CT-)\\d{4}$", message = "Id Customer Format Exception (CT-XXXX) !!!")
    private String id;
    @NotEmpty(message = "not null")
    private String startDate;
    @NotEmpty(message = "not null")
    private String endDate;
    @Min(value = 0)
    private String deposit;
    @Min(value = 0,message = "totalMoney >= 0 ")
    private String totalMoney;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "contract")
    List<ContractDetail> contractDetailList;

    public Contract() {
    }

    public Contract(String id, String startDate, String endDate, String deposit, String totalMoney) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}