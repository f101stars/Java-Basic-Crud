package Adv.models;

import jakarta.persistence.*;

@Entity
@Table
public class AdvEntrances extends baseAdv{
@Column
private int desiredEntrances;

@Column
private int usedEntrances;

public int getDesiredEntrances() {
	return desiredEntrances;
}

public void setDesiredEntrances(int desiredEntrances) {
	this.desiredEntrances = desiredEntrances;
}

public int getUsedEntrances() {
	System.out.println("hello get");
	return usedEntrances;
}

public void setUsedEntrances(int usedEntrances) {
	System.out.println("hello set");
	this.usedEntrances = usedEntrances;
}

}
