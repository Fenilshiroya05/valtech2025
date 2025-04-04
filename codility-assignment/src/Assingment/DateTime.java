package Assingment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTime {

	public static String computeTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
		if (endTime.isBefore(startTime)) {
			return "End time after start time.";
		}

		Duration duration = Duration.between(startTime, endTime);
		long days = duration.toDays();
		long hours = duration.toHours() % 24;
		long minutes = duration.toMinutes() % 60;

		return days + ": days, " + hours + ": hours, " + minutes + ": minutes";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		try {
			System.out.println("Enter start time in format of(yyyy-MM-dd HH:mm):");
			LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine(), formatter);

			System.out.println("Enter end time in format of(yyyy-MM-dd HH:mm):");
			LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine(), formatter);

			System.out.println("Time Difference: " + computeTimeDifference(startTime, endTime));
			
		} catch (Exception e) {
			
			System.out.println("Invalid input.");
		}

		scanner.close();
	}
}
