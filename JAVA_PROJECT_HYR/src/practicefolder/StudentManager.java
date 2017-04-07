package practicefolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
	private Scanner sc = new Scanner(System.in);
	static private StudentManager st;
	ArrayList<Person> personList = new ArrayList<Person>(); // 회원담을 곳
	// 삽입, 삭제보다 조회가 많을 것 같아 ArrayList로 함.

	private StudentManager() {
	};

	public static StudentManager getStudentManagerInstance() {
		if (st == null) {
			st = new StudentManager();
		}
		return st;
	}

	public void menuStart(StudentManager s) {

		System.out.println("]]]]]]]]학사관리 시스템에 입장하셨습니다.]]]]]]]]]]");
		while (true) {
			System.out.println("이용하실 메뉴를 선택해 주세요");
			System.out.println("1. 학생등록 2. 점수입력 3. 점수조회 4. 전체조회(이름순/성적순) 5. 종료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				s.enroll();
				break;
			case 2:
				s.inputScore();
				break;
			case 3:
				s.showScore();
				break;
			case 4:
				s.showEntire();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("엉둥한 값 입력하셨습니다.");
				break;
			}
		}
	}

	public void enroll() { // 회원 등록 메서드
		System.out.println("학생을 등록합니다.");
		System.out.print("이름을 입력하세요 -  입력 >>");
		String name = sc.next();
		System.out.println("나이를 입력하세요 - 입력>>");
		int age = sc.nextInt();
		personList.add(new Person(name, age)); // 학생 추가

		System.out.println(name + " : " + age + "(살) 님이 등록되었습니다.");
		// for (int i = 0; i < personList.size(); i++) {
		// System.out.println( personList.get(i).getName() + ", " + "이 등록되어
		// 있다.");
		// }
	}

	public void showEntire() {
		String sel = "";
		exit3: while (true) {
			System.out.print("이름순 or 성적순 선택하세요 : 입력 >> ");
			sel = sc.next();
			if ("이름순".equals(sel)) {
				Collections.sort(personList, new Comparator<Person>() {
					@Override
					public int compare(Person o1, Person o2) {
						// TODO Auto-generated method stub
						return o1.getName().compareTo(o2.getName());
					}
				});
				break exit3;
			} else if ("성적순".equals(sel)) {
				Collections.sort(personList, new Comparator<Person>() {
					public int compare(Person o1, Person o2) {
						double avgThis = (o1.getMath() + o1.getKor() + o1.getEng()) / 3.0;
						double avgCompare = (o2.getEng() + o2.getKor() + o2.getMath()) / 3.0;
						return (int) (avgCompare - avgThis);
					};
				});
				break exit3;
			} else {
				System.out.println("올바른 값을 입력하세요");
				continue exit3;
			}

		}

		if ("성적순".equals(sel)) {
			for (int i = 0; i < personList.size(); i++) {
				Person person = personList.get(i);
				System.out.println("등수 : " + (i + 1) + " : " + person.getName() + "의 수학,영어,국어 점수 : " + person.getMath()
						+ ", " + person.getEng() + ", " + person.getKor() + "입니다.");
			}
		}else if ( "이름순".equals(sel) ){
			for (int i = 0; i < personList.size(); i++) {
				Person person = personList.get(i);
				System.out.println(person.getName() + "의 수학,영어,국어 점수 : " + person.getMath()
						+ ", " + person.getEng() + ", " + person.getKor() + "입니다.");
			}
		}
	}

	public void showScore() {
		Person person = null;
		int index = 0;
		String name = "";
		exit2: while (true) {
			Collections.sort(personList);

			System.out.print("점수를 조회할 학생의 이름을 입력하세요 : 입력 >> ");
			name = sc.next();

			for (int i = 0; i < personList.size(); i++) {
				if (name.equals(personList.get(i).getName())) {
					person = personList.get(i);
					index = i;
					break exit2;
				}
				if (i == personList.size() - 1) {
					System.out.println("찾으시는 학생 정보가 없습니다. 다시 입력하세요");
					continue exit2;
				}
			}
		}

		System.out.println(person.getName() + "님의 수학, 영어, 국어 점수는 : " + person.getMath() + ", " + person.getEng() + ", "
				+ person.getKor() + "입니다.");
		int sum = person.getEng() + person.getMath() + person.getKor();
		System.out.printf("평균 점수는 %.3f (점)입니다.\n", (sum / 3.0));

		System.out.println(person.getName() + "님의 등수는 전체 " + (index + 1) + " (등)입니다.");
	}

	public void inputScore() { // 점수 입력 메서드
		int index = 0;
		exit1: while (true) {
			index = 0;
			System.out.print("점수를 입력할 회원의 이름을 입력하세요 : 입력 >> ");
			String name = sc.next();

			for (int i = 0; i < personList.size(); i++) {
				if (name.equals(personList.get(i).getName())) {
					index = i;
					break exit1;
				}
				if (i == personList.size() - 1) {
					System.out.println("찾는 회원이 없습니다. 다시 입력하세요");
					continue exit1;
				}
			}
		}

		Person person = personList.get(index);

		exit: while (true) {
			System.out.print(person.getName() + "님의 수학, 영어, 국어 점수 입력 >> ");
			sc.nextLine();
			String score = sc.nextLine();

			System.out.println("확인 : " + score);
			String[] scores = score.split(" ");
			System.out.println("확인");
			System.out.println("입력하신 수학, 영어, 국어 점수는 : " + scores[0] + ", " + scores[1] + ", " + scores[2] + "가 맞습니까?");
			System.out.println("예/아니오");
			String flag = sc.next();
			sc.nextLine();
			if ("예".equals(flag)) {
				person.setMath(Integer.parseInt(scores[0]));
				person.setEng(Integer.parseInt(scores[1]));
				person.setKor(Integer.parseInt(scores[2]));
				break exit;
			} else if ("아니오".equals(flag)) {
				System.out.println("그럼 다시 입력해 주세요 ");
				continue exit;
			} else {
				System.out.println("입력값이 잘못되었습니다. 다시입력하세요.");
				continue exit;
			}
		}

		person = null;
		System.gc();
		System.runFinalization();

	}

}
