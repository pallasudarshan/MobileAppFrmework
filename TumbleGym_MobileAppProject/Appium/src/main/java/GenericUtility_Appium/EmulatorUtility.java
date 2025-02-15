package GenericUtility_Appium;

import java.io.IOException;

public class EmulatorUtility {

	public static void startEmulator() throws IOException, InterruptedException {
		String emulatorPath = System.getenv("ANDROID_HOME") + "/emulator/emulator";
		String avdName = "6Pro"; // Change to your AVD name

		ProcessBuilder builder = new ProcessBuilder(emulatorPath, "-avd", avdName);
		builder.start(); // Start emulator
		Thread.sleep(30000); // Wait for emulator to boot
	}

	public static void closeEmulator() throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder("adb", "emu", "kill");
		processBuilder.start();
		System.out.println("❌ Emulator closed successfully!");
	}
}
