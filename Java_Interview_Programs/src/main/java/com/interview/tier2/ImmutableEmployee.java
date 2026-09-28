package com.interview.tier2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class ImmutableEmployee {
 private final int id;private final String name;private final Date joiningDate;private final List<String> skills;private final Address address;
 public ImmutableEmployee(int id,String name,Date d,List<String> skills,Address a){this.id=id;this.name=name;joiningDate=d==null?null:new Date(d.getTime());this.skills=skills==null?Collections.emptyList():Collections.unmodifiableList(new ArrayList<>(skills));this.address=a==null?null:new Address(a);}
 public int getId(){return id;}public String getName(){return name;}public Date getJoiningDate(){return joiningDate==null?null:new Date(joiningDate.getTime());}public List<String> getSkills(){return Collections.unmodifiableList(new ArrayList<>(skills));}public Address getAddress(){return address==null?null:new Address(address);}
 public static final class Address{private final String city,state;public Address(String c,String s){city=c;state=s;}private Address(Address a){city=a.city;state=a.state;}public String getCity(){return city;}public String getState(){return state;}}
}
