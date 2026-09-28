package com.interview.tier3;
import java.util.*; import java.util.stream.Collectors;
public class EmployeeGroupingAndAggregation {
 public record Employee(int id,String name,String department,double salary){}
 public static Map<String,Double> stream(List<Employee> e){return e.stream().collect(Collectors.groupingBy(Employee::department,Collectors.averagingDouble(Employee::salary)));}
 public static Optional<Map.Entry<String,Double>> highestAverage(List<Employee> e){return stream(e).entrySet().stream().max(Map.Entry.comparingByValue());}
 public static Map<String,Double> optimized(List<Employee> e){Map<String,double[]> m=new HashMap<>();for(Employee x:e){double[] a=m.computeIfAbsent(x.department(),k->new double[2]);a[0]+=x.salary();a[1]++;}Map<String,Double> r=new HashMap<>();m.forEach((k,v)->r.put(k,v[0]/v[1]));return r;}
 public static void main(String[] args){List<Employee> e=Arrays.asList(new Employee(1,"A","IT",80000),new Employee(2,"B","IT",90000),new Employee(3,"C","HR",70000),new Employee(4,"D","Finance",95000));System.out.println(stream(e));System.out.println(highestAverage(e));System.out.println(optimized(e));}
}
