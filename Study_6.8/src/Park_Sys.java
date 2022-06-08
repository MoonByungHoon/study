class Park_Sys {
	private int num;
	private String car_num;
	private int hour;
	private int minute;

	Park_Sys(int num, String car_num, int hour, int minute) {
		this.num = num;
		this.car_num = car_num;
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}
}