package com.silvertech.dsalgo.concurrency;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EmployeeResource {

  private final EmployeeStore store;

  public EmployeeResource(EmployeeStore store) {
    this.store = store;
  }

  public Map<UUID,Employee> getAll() throws InterruptedException {
    Thread.sleep(10000);
    return store.employees;
  }

  public Employee getById(UUID id) throws InterruptedException {
    Thread.sleep(5000);
    return store.employees.get(id);
  }
}
