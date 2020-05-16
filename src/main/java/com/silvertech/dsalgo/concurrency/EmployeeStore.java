package com.silvertech.dsalgo.concurrency;

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public enum EmployeeStore {
  Instance;
  final Map<UUID,Employee> employees;

  final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

  final java.util.Random rand = new java.util.Random();

  final Set<String> identifiers = new HashSet<String>();

  private EmployeeStore(){
    employees = new ConcurrentHashMap<>();
    IntStream.range(0,1000).forEach(i->{
      Employee employee = new Employee(
          UUID.randomUUID(),
          randomIdentifier(),
          randomIdentifier());
      this.employees.put(employee.getId(),employee);
    });
  }

  public String randomIdentifier() {
    StringBuilder builder = new StringBuilder();
    while(builder.toString().length() == 0) {
      int length = rand.nextInt(5)+5;
      for(int i = 0; i < length; i++) {
        builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
      }
      if(identifiers.contains(builder.toString())) {
        builder = new StringBuilder();
      }
    }
    return builder.toString();
  }
}
