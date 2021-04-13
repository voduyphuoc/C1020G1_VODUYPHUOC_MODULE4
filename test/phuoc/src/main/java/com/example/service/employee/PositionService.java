package com.example.service.employee;

import com.example.entity.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    void save(Position position);

    Position findById(Integer id);

    void remove(Integer id);
}
