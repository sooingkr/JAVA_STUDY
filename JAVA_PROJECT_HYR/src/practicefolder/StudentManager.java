package practicefolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
	private Scanner sc = new Scanner(System.in);
	static private StudentManager st;
	ArrayList<Person> personList = new ArrayList<Person>(); // ȸ������ ��
	// ����, �������� ��ȸ�� ���� �� ���� ArrayList�� ��.

	private StudentManager() {
	};

	public static StudentManager getStudentManagerInstance() {
		if (st == null) {
			st = new StudentManager();
		}
		return st;
	}

	public void menuStart(StudentManager s) {

		System.out.println("]]]]]]]]�л���� �ý��ۿ� �����ϼ̽��ϴ�.]]]]]]]]]]");
		while (true) {
			System.out.println("�̿��Ͻ� �޴��� ������ �ּ���");
			System.out.println("1. �л���� 2. �����Է� 3. ������ȸ 4. ��ü��ȸ(�̸���/������) 5. ����");
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
				System.out.println("������ �� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	public void enroll() { // ȸ�� ��� �޼���
		System.out.println("�л��� ����մϴ�.");
		System.out.print("�̸��� �Է��ϼ��� -  �Է� >>");
		String name = sc.next();
		System.out.println("���̸� �Է��ϼ��� - �Է�>>");
		int age = sc.nextInt();
		personList.add(new Person(name, age)); // �л� �߰�

		System.out.println(name + " : " + age + "(��) ���� ��ϵǾ����ϴ�.");
		// for (int i = 0; i < personList.size(); i++) {
		// System.out.println( personList.get(i).getName() + ", " + "�� ��ϵǾ�
		// �ִ�.");
		// }
	}

	public void showEntire() {
		String sel = "";
		exit3: while (true) {
			System.out.print("�̸��� or ������ �����ϼ��� : �Է� >> ");
			sel = sc.next();
			if ("�̸���".equals(sel)) {
				Collections.sort(personList, new Comparator<Person>() {
					@Override
					public int compare(Person o1, Person o2) {
						// TODO Auto-generated method stub
						return o1.getName().compareTo(o2.getName());
					}
				});
				break exit3;
			} else if ("������".equals(sel)) {
				Collections.sort(personList, new Comparator<Person>() {
					public int compare(Person o1, Person o2) {
						double avgThis = (o1.getMath() + o1.getKor() + o1.getEng()) / 3.0;
						double avgCompare = (o2.getEng() + o2.getKor() + o2.getMath()) / 3.0;
						return (int) (avgCompare - avgThis);
					};
				});
				break exit3;
			} else {
				System.out.println("�ùٸ� ���� �Է��ϼ���");
				continue exit3;
			}

		}

		if ("������".equals(sel)) {
			for (int i = 0; i < personList.size(); i++) {
				Person person = personList.get(i);
				System.out.println("��� : " + (i + 1) + " : " + person.getName() + "�� ����,����,���� ���� : " + person.getMath()
						+ ", " + person.getEng() + ", " + person.getKor() + "�Դϴ�.");
			}
		}else if ( "�̸���".equals(sel) ){
			for (int i = 0; i < personList.size(); i++) {
				Person person = personList.get(i);
				System.out.println(person.getName() + "�� ����,����,���� ���� : " + person.getMath()
						+ ", " + person.getEng() + ", " + person.getKor() + "�Դϴ�.");
			}
		}
	}

	public void showScore() {
		Person person = null;
		int index = 0;
		String name = "";
		exit2: while (true) {
			Collections.sort(personList);

			System.out.print("������ ��ȸ�� �л��� �̸��� �Է��ϼ��� : �Է� >> ");
			name = sc.next();

			for (int i = 0; i < personList.size(); i++) {
				if (name.equals(personList.get(i).getName())) {
					person = personList.get(i);
					index = i;
					break exit2;
				}
				if (i == personList.size() - 1) {
					System.out.println("ã���ô� �л� ������ �����ϴ�. �ٽ� �Է��ϼ���");
					continue exit2;
				}
			}
		}

		System.out.println(person.getName() + "���� ����, ����, ���� ������ : " + person.getMath() + ", " + person.getEng() + ", "
				+ person.getKor() + "�Դϴ�.");
		int sum = person.getEng() + person.getMath() + person.getKor();
		System.out.printf("��� ������ %.3f (��)�Դϴ�.\n", (sum / 3.0));

		System.out.println(person.getName() + "���� ����� ��ü " + (index + 1) + " (��)�Դϴ�.");
	}

	public void inputScore() { // ���� �Է� �޼���
		int index = 0;
		exit1: while (true) {
			index = 0;
			System.out.print("������ �Է��� ȸ���� �̸��� �Է��ϼ��� : �Է� >> ");
			String name = sc.next();

			for (int i = 0; i < personList.size(); i++) {
				if (name.equals(personList.get(i).getName())) {
					index = i;
					break exit1;
				}
				if (i == personList.size() - 1) {
					System.out.println("ã�� ȸ���� �����ϴ�. �ٽ� �Է��ϼ���");
					continue exit1;
				}
			}
		}

		Person person = personList.get(index);

		exit: while (true) {
			System.out.print(person.getName() + "���� ����, ����, ���� ���� �Է� >> ");
			sc.nextLine();
			String score = sc.nextLine();

			System.out.println("Ȯ�� : " + score);
			String[] scores = score.split(" ");
			System.out.println("Ȯ��");
			System.out.println("�Է��Ͻ� ����, ����, ���� ������ : " + scores[0] + ", " + scores[1] + ", " + scores[2] + "�� �½��ϱ�?");
			System.out.println("��/�ƴϿ�");
			String flag = sc.next();
			sc.nextLine();
			if ("��".equals(flag)) {
				person.setMath(Integer.parseInt(scores[0]));
				person.setEng(Integer.parseInt(scores[1]));
				person.setKor(Integer.parseInt(scores[2]));
				break exit;
			} else if ("�ƴϿ�".equals(flag)) {
				System.out.println("�׷� �ٽ� �Է��� �ּ��� ");
				continue exit;
			} else {
				System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ��Է��ϼ���.");
				continue exit;
			}
		}

		person = null;
		System.gc();
		System.runFinalization();

	}

}
