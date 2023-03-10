package gslc_1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class ToDoList {
	
	public int choice;
	public ArrayList<Schedule> toDoList = new ArrayList<>();
	public Scanner scan = new Scanner(System.in);
	SimpleDateFormat ft = new SimpleDateFormat("E, dd.MM.yyyy");

	
	public ToDoList() {
		while(true) {
			System.out.println("WELCOME TO YOUR TO DO LIST");
			System.out.println("==========================");
			System.out.println("1. View My To Do List");
			System.out.println("2. Add New Task");
			System.out.println("3. Update My To Do List");
			System.out.println("4. Delete from my To Do List");
			System.out.println("5. Exit");
			System.out.print(">> ");
			choice = scan.nextInt();
			scan.nextLine();
			
			switch (choice) {
				case 1: {
					view();
					break;
				}
				
				case 2: {
					newTask();				
					break;				
				}
				
				case 3: {
					update();
					break;
				}
				
				case 4: {
					delete();
					break;
				}
				
				case 5: {
					return;
				}
			
			}
		}
	}


	private void delete() {
		view();
		System.out.print("Select Task you want to delete (0 to exit) : ");
		int delete = scan.nextInt();
		scan.nextLine();
		
		toDoList.remove(delete-1);
		
	}


	private void update() {
		view();
		System.out.print("Select Task you want to update (0 to exit) : ");
		int update = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Do you want to change the task name? (y/n) : ");
		String yesno = scan.nextLine();
		
		if(yesno.equals("y")) {
			System.out.print("Task name : ");
			String name = scan.nextLine();
			toDoList.get(update-1).setTaskName(name);
		}
		
		
		System.out.println("Do you want to change the task deadline? (y/n) : ");
		yesno = scan.nextLine();
		if(yesno.equals("y")) {
			System.out.print("Day Deadline (1-31) : ");
			int day = scan.nextInt();
			scan.nextLine();
			
			System.out.print("Month Deadline (1-12) : ");
			int month = scan.nextInt();
			scan.nextLine();
			
			System.out.print("Year Deadline : ");
			int year = scan.nextInt();
			scan.nextLine();
			
			Date date = new Date(year-1900, month-1, day);
			toDoList.get(update-1).setTaskDeadline(date);
		}

	}


	private void view() {
		if(toDoList.isEmpty()) {
			System.out.println("No Task");
			return;
		}
		

		System.out.println("+===========================+======================+");
		System.out.printf("| %-25s | %-20s |\n", "Task Name","Deadline");
		System.out.println("+===========================+======================+");
		for (Schedule s : toDoList) {
			System.out.printf("| %-25s | %-20s |\n", s.getTaskName(),ft.format(s.getTaskDeadline()));
		}
		System.out.println("+===========================+======================+");
		
	}


	private void newTask() {
		int day,month,year;
		String name;
		
		System.out.print("Task name : ");
		name = scan.nextLine();
		
		System.out.print("Day Deadline (1-31) : ");
		day = scan.nextInt();
		scan.nextLine();
		
		System.out.print("Month Deadline (1-12) : ");
		month = scan.nextInt();
		scan.nextLine();
		
		System.out.print("Year Deadline : ");
		year = scan.nextInt();
		scan.nextLine();
		
		Date date = new Date(year-1900, month-1, day);
		
		toDoList.add(new Schedule(name, date));
		Collections.sort(toDoList);
	}


	public static void main(String[] args) {	
		new ToDoList();
	}
	
	

}
