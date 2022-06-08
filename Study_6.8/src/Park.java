import java.time.LocalTime;
import java.util.ArrayList;

public class Park {

	public static void main(String[] args) {
		ArrayList<Park_Sys> park = new ArrayList<>();
		PutMessage pm = new PutMessage();
		int pick;

		Loop: while ((pick = pm.menu()) != 0) {
			switch (pick) {
			case 1:
				if (park.size() == 5) {
					System.out.println("만차입니다.");

					continue Loop;
				}

				for (int i = 0; i < 5; i++) {
					
					if (park.size() != 0) {
						System.out.println("11");
						
						if (park.isEmpty() == false) {
							park.add(new Park_Sys(i + 1, pm.in_Car(), LocalTime.now().getHour(),
									LocalTime.now().getMinute()));
							
							System.out.println("입차가 완료되었습니다.");

							continue Loop;
						}
					}

					if (park.size() == 0) {
						park.add(new Park_Sys(i + 1, pm.in_Car(), LocalTime.now().getHour(),
								LocalTime.now().getMinute()));
						
						System.out.println("입차가 완료되었습니다.");

						continue Loop;
					}
				}

				continue Loop;
			case 2:
				if (park.size() == 0) {
					System.out.println("주차된 차량이 없습니다.");

					continue Loop;
				}

				for (int i = 0; i < 5; i++) {
					
					if (park.get(i).getCar_num().equals(pm.out_Car())) {
						int price = ((LocalTime.now().getHour() * 60 + LocalTime.now().getMinute())
								- (park.get(i).getHour() * 60 + park.get(i).getMinute())) / 10 * 1000;

						System.out.printf("주차비용이 %d 만큼 나왔습니다.", price);
						System.out.println();
						System.out.println("출차가 완료되었습니다.");
						
						park.remove(i);

						continue Loop;
					}
				}

				continue Loop;
			default:
				System.out.println("잘못 입력하셨습니다.");

				continue Loop;
			}//스위치
		}//while
	}// main
}// park
