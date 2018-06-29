package org.WanderlustAirways.VO;

public class FlightstatusVO {
	private int flightStatusId;
	private String flightno;
	private String departureTime;
	private String arrivalTime;
	private String originCode;
	private String destinationCode;
	private String Status;
	
	public int getFlightStatusId() {
		return flightStatusId;
	}

	public void setFlightStatusId(int flightStatusId) {
		this.flightStatusId = flightStatusId;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getOriginCode() {
		return originCode;
	}

	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}

	public String getDestinationCode() {
		return destinationCode;
	}

	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
