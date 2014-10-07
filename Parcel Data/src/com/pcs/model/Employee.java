package com.pcs.model;

import android.content.Context;
import android.os.Parcel;


import android.os.Parcelable;

/***
 * Declare a class which implements parcelable 
 * which gives two override methods and a constructor
 * @author pcs
 *
 */

public class Employee implements Parcelable {
	
	public Context context;
	private static String name;
	private static String id;
	private static String designation;

	public Employee() {
		
		

	}
	
	/***
	 * Read the string through source and sets it
	 */
	
	public Employee(Parcel source) {
		
	
		
		setName(source.readString());
		setId(source.readString());
		setDesignation(source.readString());

	}
	
	/***
	 * Generate Getters and setters to get the details
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		Employee.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		Employee.id = id;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		Employee.designation = designation;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	/***
	 * this override method writes the string into the destination
	 */
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {

		
		dest.writeString(getName());
		dest.writeString(getId());
		dest.writeString(getDesignation());

	}
	
	public static final Creator<Employee> CREATOR = new Creator<Employee>(){

		@Override
		public Employee createFromParcel(Parcel source) {
			return new Employee(source);
		}

		@Override
		public Employee[] newArray(int size) {
			return new Employee[size];
		}

	};
	
	/***
	 * Returns the employee name, id, designation
	 */

	public String toString() {

		return "\nEmployee Name :\t"+ getName()+
				"\nEmployee Id :\t"+ getId()+"" +
						"\nEmployee Designation :\t"+getDesignation();

	};

}
