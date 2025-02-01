package Hello_Bff_GenericUtility;

import java.io.File;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

/**
 * This class contains Java specific Reusable Methods
 * 
 * @author Sudarshan
 *
 */
public class JavaUtility {
	/**
	 * This method is used
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		return new Random().nextInt(10000);
	}

	public int getRandomNumbers() {
		return new Random().nextInt(10_000_000);
	}

	/**
	 * This method is used to get system date and Time in IST format
	 * 
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString().toString().replace(":", "-");
	}

	public char generateRandomCharacter() {
		return (char) ('a' + new Random().nextInt(26));
	}

	/**
	 * This method is used to get system Date in YYYY-MM-DD format
	 * 
	 * @return
	 */
	public String getSystemDateWithFormat() {
		Date date = new Date();
		String dateAndTime = date.toString();
		String YYYY = dateAndTime.split("")[5];
		String DD = dateAndTime.split("")[2];
		int MM = date.getMonth() + 1;
		String finalFormat = date.getTime() + "-" + YYYY + "-" + MM + "-" + DD;
		return finalFormat;
	}

	/*
	 * 12122023
	 */
	public String currentDateFormattedYYMMDD() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	public String currentDate() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
	}

	/**
	 * This method used get the current date and time Sat Jun 17 21:37:57 IST 2023
	 * 
	 */
	public Date getTheCurrentDateAndTime() {
		return new Date();
	}

	/*
	 * Sat Jun 17 21:37:57 IST 2023
	 */
	public Date currentDate_dd_m_y() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return date;
	}

	public String removeFirstCharctersAndLastCharters(String str, int lastNum, int firstNum) {
		String t = str.substring(0, str.length() - lastNum);
		String result = t.substring(firstNum);
		return result;
	}

	public String removeLast_n_NumberOfCharacters(String str, int n) {
		String lastRemoved = str.substring(0, str.length() - 4);
		return lastRemoved;
	}

	public String removeFirst_n_NumberOfCharacters(String str, int n) {
		String firstRemoved = str.substring(n);
		return firstRemoved;
	}

	public String generatingNumber() {
		int min = 1;
		int max = 100;
		int count = 10;
		Set<Integer> bednumberh = new HashSet();
		Random random = new Random();
		while (bednumberh.size() < count) {
			bednumberh.add(random.nextInt((max - min) + 1) + min);
		}
		return bednumberh.toString();
	}

	/*
	 * MM
	 */
	public String generateCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		return date;
	}

	/*
	 * DD
	 */
	public String generateCurrentMonth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		return date;
	}

	/*
	 * YYYY
	 */
	public String generateCurrentYear() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		return date;
	}

	/*
	 * 123!@ rrRE
	 * 
	 * result 123rrRE
	 */
	public String removedSpecialCharctersAndRemovedSpaces(String str, int length) {
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
		String lastRemoved = str.substring(0, str.length() - length);
		lastRemoved = lastRemoved.replaceAll("\\s+", "");
		return lastRemoved;
	}

	/*
	 * 123!@ rrRE
	 * 
	 * result 123rrRE
	 */
	public String removeSpecialCharactersAndRemoveSpeces_RemoveLastCharacters(String str, int length) {
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
		String lastRemoved = str.substring(0, str.length() - length);
		lastRemoved = lastRemoved.replaceAll("\\s+", "");
		return lastRemoved;
	}

	/*
	 * 123!@ rrRE
	 * 
	 * result rrRE
	 */
	public String removeSpecialCharactersAndNumbers_RemoveLastCharacters(String str, int length) {
		str = str.replaceAll("[^a-zA-Z]", " ");
		String lastRemoved = str.substring(0, str.length() - length);
		return lastRemoved;
	}

	/*
	 * 123!@ rrRE
	 * 
	 * result 123rrRE
	 */
	public String removeSpecialCharacters_And_Speces(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
		return str = str.replaceAll("\\s+", "");
	}

	/*
	 * current month
	 * 
	 */
	public String currentMonth() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));
	}

	public List<String> getTextFromElements(List<WebElement> elements) {
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

	@Test
	public String current_Time_Hours_Min() {
		LocalTime currentTime = LocalTime.now();
		LocalTime futureTime = currentTime.plusMinutes(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
		String formattedFutureTime = futureTime.format(formatter);
		return formattedFutureTime;
	}

	public String generateRandomEmail() {
		String domain = "example.com";
		String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int emailLength = 10; // You can adjust the length of the email as needed
		StringBuilder email = new StringBuilder();
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < emailLength; i++) {
			int randomIndex = random.nextInt(allowedChars.length());
			char randomChar = allowedChars.charAt(randomIndex);
			email.append(randomChar);
		}
		email.append('@').append(domain);
		return email.toString();
	}

	public static String generateTenDaysAgoDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate tenDaysAgo = currentDate.minusDays(10);
		String dayOfMonth = dtf.format(tenDaysAgo);
		return dayOfMonth;
	}

	public String generate_RandomNumbers() {
		Set<Integer> generatedNumbers = new HashSet<>();
		Random random = new Random();

		int minValue = 1;
		int maxValue = 10000000;
		while (true) {
			int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
			if (!generatedNumbers.contains(randomNumber)) {
				generatedNumbers.add(randomNumber);
				String bednumberh = String.valueOf(randomNumber);
				return bednumberh;
			}
		}
	}

	public static String generateTwoDaysAgoDate_ddmmyyyy() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -2);
		Date twoDaysAgo = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(twoDaysAgo);
		return formattedDate;
	}

	public static String generateTwoDaysFutureDate_ddmmyyyy() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, +2);
		Date twoDaysAgo = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(twoDaysAgo);
		return formattedDate;
	}

	public String currentDateFormateYYMMDD() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date currentDate = new Date();
		String formattedDate = dateFormat.format(currentDate);
		return formattedDate;
	}

	/*
	 * 20230925
	 * 
	 */
	public String currentDate_yyyymmdd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date currentDate = new Date();
		String formattedDate = sdf.format(currentDate);
		return formattedDate;
	}

	public String remove_All_ExceptNumbers(String input, int value) {
		String result = input.replaceAll("[^0-9]", "");
		return result;
	}

	public String generateRandomMobileNumber() {
		Random rand = new Random();

		StringBuilder mobileNumber = new StringBuilder("0");
		for (int i = 0; i < 9; i++) {
			mobileNumber.append(rand.nextInt(10));
		}
		return mobileNumber.toString();
	}

	public String generateRandomAadhaarNumber() {
		Random random2 = new Random();
		long aadhaarNumber = 100000000000L + random2.nextInt(900000000);
		String aadhaar = Long.toString(aadhaarNumber);
		return aadhaar;
	}

	public String remove_Characters_And_FirstCharcatersRemove(String str, int n) {
		String regex = "[a-zA-Z]";
		String result = str.replaceAll(regex, "");
		String firstRemoved = result.substring(n);
		return firstRemoved;
	}

	public String getTheName_RemoveTheSpaces(String input) {
		Pattern pattern = Pattern.compile("([A-Za-z ]+)");
		String nameWithoutSpaces = "";
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			String nameWithSpaces = matcher.group(1);
			nameWithoutSpaces = nameWithSpaces.replaceAll(" ", "");
		} else {

		}
		return nameWithoutSpaces;
	}

	public String generateCurrentDate_DDMMYYYY() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	public String generateCurrentDate_YYYYMMDD() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	public String currentDateAnd_TimeMinSeconds() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public String currentDate_Dd_Mm_Yyyy() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

	/*
	 * 29-09-2023 08:24
	 */
	public String curretDateAndTime_DDMMYYY_H_M() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime currentDateTime = LocalDateTime.now();
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}

	public String remove_SpecialCharacters_And_Numbers_Speces(String inputString, int length) {
		inputString = inputString.replaceAll("[^a-zA-Z\\s]+", "");
		String lastRemoved = inputString.substring(0, inputString.length() - length);
		return lastRemoved;
	}

	/*
	 * 30-Sep-2023
	 * 
	 */
	public String generateCurrentTime_HHMM() {
		LocalTime currentTime = LocalTime.now();
		LocalTime increasedTime = currentTime.plusMinutes(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
		String formattedTime = increasedTime.format(formatter);
		return formattedTime;
	}

	public String generateCurrentDate_dd_Month_yy() {
		Date date = new Date(1230768000000L);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = dateFormat.format(date);
		System.out.println("Formatted Date: " + formattedDate);
		return formattedDate;
	}

	public String removeFirstCharacters_And_RemoveSpecialCharacters_AndSpaces(String inputString, int length) {
		String cleanedString = inputString.replaceAll("[^a-zA-Z]", "");
		String result = cleanedString.substring(length);
		return result;
	}

	public String removeFirstCharctersAndLastCharters_WithSpecialCharacters(String str, int lastNum, int firstNum) {
		String string = str.replaceAll("[^a-zA-Z]", "");
		String result = string.substring(2);
		String string1 = result.substring(0, result.length() - 2);
		return string1;
	}

	public String removeSpecialCharactersAndFirstCharacters(String input, int n) {
		String stringWithoutSpecialChars = input.replaceAll("[^a-zA-Z0-9]", " ");
		String first = stringWithoutSpecialChars.substring(n);
		return first;
	}

	/*
	 * 04Oct2023
	 */
	public String generate_CurrentDate_dd_Month_Yy() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("ddMMMyyyy", Locale.ENGLISH);
		String formattedDate = currentDate.format(customFormatter);
		return formattedDate;
	}

	public String generateCurrentDateAndMinus_dd(int days) {
		LocalDate currentDate = LocalDate.now();
		LocalDate newDate = currentDate.minusDays(days);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
		String formattedDate = newDate.format(formatter);
		return formattedDate;
	}

	public String generateMonthInWords() {
		Month currentMonth = Month.values()[java.time.LocalDate.now().getMonthValue() - 1];
		String currentMonthName = currentMonth.getDisplayName(java.time.format.TextStyle.FULL, Locale.US);
		return currentMonthName;
	}

	public String generateDateForDatePicker_MinusDate(int day) {
		LocalDate currentDate = LocalDate.now();
		LocalDate newDate = currentDate.minusDays(day);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
		String formattedDate = newDate.format(formatter);
		return formattedDate;
	}

	public String generateDate_minusDate_ddMMyyyy(int minusDays) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(dateFormat);
		System.out.println("Current Date: " + formattedDate);
		LocalDate subtractedDate = currentDate.minus(minusDays, ChronoUnit.DAYS);
		String formattedSubtractedDate = subtractedDate.format(dateFormat);
		return formattedSubtractedDate;
	}

	public String generateDate_PlusDate_ddMMyyyy(int plusDays) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(dateFormat);
		System.out.println("Current Date: " + formattedDate);
		LocalDate subtractedDate = currentDate.plus(plusDays, ChronoUnit.DAYS);
		String formattedSubtractedDate = subtractedDate.format(dateFormat);
		return formattedSubtractedDate;
	}

	public String generateDate_minusDate_dd_MM_yyyy(int minusDays) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(dateFormat);
		System.out.println("Current Date: " + formattedDate);
		LocalDate subtractedDate = currentDate.minus(minusDays, ChronoUnit.DAYS);
		String formattedSubtractedDate = subtractedDate.format(dateFormat);
		return formattedSubtractedDate;
	}

	public String generatePhoneNumber() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
		String formattedDateTime = now.format(formatter);
		return formattedDateTime;
	}

	public String generateRandomGST() {
		Random random = new Random();
		String stateCode = String.format("%02d", random.nextInt(100));
		StringBuilder panBuilder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			char randomChar = (char) ('A' + random.nextInt(26));
			panBuilder.append(randomChar);
		}
		String pan = panBuilder.toString();
		String entityCode = String.valueOf(random.nextInt(10));
		String checkCode = String.valueOf(random.nextInt(10));
		String gstNumber = stateCode + pan + entityCode + "Z" + checkCode;
		return gstNumber;
	}

	public String generateRandomPAN() {
		Random random = new Random();
		StringBuilder panBuilder = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			char randomChar = (char) ('A' + random.nextInt(26));
			panBuilder.append(randomChar);
		}
		for (int i = 0; i < 4; i++) {
			panBuilder.append(random.nextInt(10));
		}
		char lastChar = (char) ('A' + random.nextInt(26));
		panBuilder.append(lastChar);
		String panNumber = panBuilder.toString();
		return panNumber;
	}

	private static final String[] streets = { "Maple Street", "Oak Avenue", "Elm Lane", "Pine Road", "Cedar Boulevard",
			"Birch Lane", "Willow Drive", "Cedar Street", "Oakwood Avenue", "Pinehurst Lane", "Elmwood Drive",
			"Walnut Street", "Birchwood Lane", "Maple Avenue", "Chestnut Boulevard", "Aspen Lane", "Sycamore Road",
			"Redwood Drive", "Laurel Street", "Juniper Avenue", "Magnolia Lane", "Cypress Road", "Spruce Boulevard",
			"Hemlock Lane", "Cedarwood Drive", "Pinecrest Street", "Aspenwood Lane", "Oakhurst Avenue",
			"Birchcrest Road", "Willowwood Boulevard", "Linden Lane", "Holly Street", "Cypress Lane", "Fir Road",
			"Locust Drive", "Poplar Avenue", "Birchwood Drive", "Maplewood Road", "Oakridge Lane", "Pineview Avenue",
			"Elmwood Boulevard", "Cedarcrest Drive", "Redwood Lane", "Birchwood Street", "Willow Lane",
			"Magnolia Drive", "Sycamore Avenue", "Chestnut Lane", "Aspen Avenue", "Juniper Boulevard", "Spruce Street",
			"Hemlock Avenue", "Cedarwood Lane", "Pinecrest Drive", "Aspenwood Road", "Oakhurst Lane",
			"Birchcrest Boulevard", "Willowwood Avenue", "Linden Drive", "Holly Lane", "Cypress Street", "Fir Lane",
			"Locust Avenue", "Poplar Lane", "Birchwood Boulevard", "Maplewood Avenue", "Oakridge Drive",
			"Pineview Lane", "Elmwood Street", "Cedarcrest Boulevard", "Redwood Avenue", "Birchwood Lane",
			"Willow Street", "Magnolia Lane", "Sycamore Drive", "Chestnut Boulevard", "Aspen Lane", "Juniper Avenue",
			"Spruce Road", "Hemlock Lane", "Cedarwood Drive", "Pinecrest Street", "Aspenwood Lane", "Oakhurst Avenue",
			"Birchcrest Road", "Willowwood Boulevard", "Linden Lane", "Holly Street", "Cypress Lane", "Fir Road",
			"Locust Drive", "Poplar Avenue", "Birchwood Drive", "Maplewood Road", "Oakridge Lane", "Pineview Avenue",
			"Elmwood Boulevard", "Cedarcrest Drive", "Redwood Lane", "Birchwood Street" };

	private static final String[] colonies = { "Springfield", "Riverside", "Pineville", "Oak Ridge", "Meadowbrook",
			"Greenfield", "Westwood", "Mountain View", "Pleasant Valley", "Maplewood", "Hampton", "Bloomington",
			"Fairfield", "Cedar Grove", "Sunset Hills", "Riverdale", "Harbor City", "Highland Park", "Bayview",
			"Lakeside", "Hillcrest", "Crestwood", "Evergreen", "Woodland Hills", "Parkside", "Willowbrook",
			"Valley Glen", "Greenwood", "Oak Park", "Ridgefield", "Pine Grove", "Rolling Hills", "Heritage Hills",
			"Brookside", "Belmont", "Ashland", "Georgetown", "Washington Square", "Lexington", "Libertyville",
			"Rockville", "Union City", "Independence", "Liberty Hills", "Colonial Heights", "Baywood", "Eagle Point",
			"Falcon Ridge", "Serenity Acres", "Magnolia Park", "Plantation", "Meadow Vista", "Prairie View", "Marigold",
			"Elmwood", "Stonewood", "Lakeview", "Timber Ridge", "Cloverdale", "Greenwood Hills", "Willow Creek",
			"Cottonwood", "Crystal Springs", "Ivy League", "Golden Meadows", "Silver Creek", "Blue Ridge",
			"Redwood Grove", "Autumn Ridge", "Sandy Springs", "Brookhaven", "Sycamore Ridge", "Meadow Ridge",
			"Windsor Park", "Sunset Ridge", "Millbrook", "Woodridge", "Prairie Grove", "Oakdale", "Wildwood",
			"Laurelwood", "Stonegate", "Hidden Valley", "Waterford", "Forest Hills", "Whispering Pines", "Fair Oaks",
			"Sunset Acres", "Spring Valley", "Meadowlands", "Fox Hollow", "Hampton Park", "Copperfield",
			"Windmill Farms", "Pine Creek", "Hillside", "Northgate", "Woodfield", "Paradise Valley", "Kingswood" };

	public void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			String address = generateRandomAddress();
			System.out.println(address);
		}
	}

	public String generateRandomAddress() {
		Random random = new Random();
		String street = streets[random.nextInt(streets.length)];
		String colony = colonies[random.nextInt(colonies.length)];
		int buildingNumber = 1 + random.nextInt(100);
		return String.format("Street: %s, Colony: %s, Building: %d", street, colony, buildingNumber);
	}

	public String generateRandomSICCode() {
		Random random = new Random();
		int randomSICNumber = 1000 + random.nextInt(8999);
		String randomSICNumber1 = String.valueOf(randomSICNumber);
		return randomSICNumber1;
	}

	private static final String[] pincodes = { "10001", "30303", "75201", "90210", "60601", "33101", "94102", "20001",
			"90001", "19103", "37201", "97201", "85001", "30339", "60661", "75205", "10021", "90212", "60610", "30328",
			"75039", "33139", "94109", "20024", "90024", "19107", "37209", "97209", "85013", "30305", "60654", "75209",
			"10011", "90230", "60614", "30318", "75063", "33130", "94123", "20002", "90036", "19147", "37215", "97214",
			"85016", "30327", "60657", "75225", "10003", "90245", "60611", "30309", "75080", "33131", "94117", "20009",
			"90046", "19102", "37203", "97210", "85018", "30319", "60647", "75214", "10014", "90254", "60613", "30363",
			"75019", "33132", "94115", "20036", "90028", "19123", "37206", "97211", "85003", "30322", "60642", "75214",
			"10036", "90210", "60618", "30312", "75038", "33133", "94105", "20004", "90049", "19130", "37207", "97213",
			"85017", "30324", "60634", "75218", "10065", "90260", "60622", "33134" };

	public String getRandomZip() {
		String pincodes2 = "";
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			String pincodes1 = pincodes[random.nextInt(pincodes.length)];
			pincodes2 = pincodes1;
		}
		return pincodes2;
	}

	private static final String[] WEBSITE_PREFIXES = { "www", "web", "tech", "info", "data", "cloud", "app" };
	private static final String[] WEBSITE_NAMES = { "example", "sample", "test", "demo", "my", "your", "awesome" };
	private static final String[] DOMAIN_EXTENSIONS = { ".com", ".org", ".net", ".io", ".co", ".xyz", ".tech" };

	/**
	 * This method used for generating the random websites
	 * 
	 * @return
	 */
	public String generateRandomWebsite() {
		Random random = new Random();
		String randomPrefix = getRandomElement(WEBSITE_PREFIXES, random);
		String randomName = getRandomElement(WEBSITE_NAMES, random);
		String randomExtension = getRandomElement(DOMAIN_EXTENSIONS, random);
		return randomPrefix + "." + randomName + randomExtension;
	}

	private static String getRandomElement(String[] array, Random random) {
		int randomIndex = random.nextInt(array.length);
		return array[randomIndex];
	}

	public String generateRandomDescriptionData(int count) {
		String[] words = { "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "sed", "do",
				"eiusmod" };
		Random random = new Random();
		StringBuilder randomDescription = new StringBuilder();
		int numberOfWords = random.nextInt(10) + count;
		for (int i = 0; i < numberOfWords; i++) {
			int randomIndex = random.nextInt(words.length);
			randomDescription.append(words[randomIndex]).append(" ");
		}
		return randomDescription.toString().trim();
	}

	public String generateRandomNumber() {
		long timestamp = System.currentTimeMillis();
		Random random = new Random(timestamp);
		int randomNumber = random.nextInt();
		String stringValue = String.valueOf(randomNumber);
		return stringValue;
	}

	public Set<Integer> generateUniqueAscendingNumbers() {
		Set<Integer> uniqueNumbers = new HashSet<>();
		for (int i = 1; i <= 100000000; i++) {
			uniqueNumbers.add(i);
		}
		return uniqueNumbers;
	}

	public String generatePassportNumber() {
		StringBuilder passportNumber = new StringBuilder("P");
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			if (random.nextBoolean()) {
				passportNumber.append(random.nextInt(10));
			} else {
				passportNumber.append((char) (random.nextInt(26) + 'A'));
			}
		}
		return passportNumber.toString();
	}

	public String generateCurrentDateFormat_MM_DD_YYYY() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = dateFormat.format(currentDate);
		return formattedDate;
	}

	// Helper method to generate a random year
	private static int getRandomYear(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	public String generateRandom_Years_MM_DD_YYYY() {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int pastYear = getRandomYear(1970, currentYear);
		calendar.set(Calendar.YEAR, pastYear);
		Date pastYearDate = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String pastYearDateString = sdf.format(pastYearDate);
		return pastYearDateString;
	}

	public String generateRandomFaxNumber() {
		Random random = new Random();
		int areaCode = random.nextInt(900) + 100;
		int exchangeCode = random.nextInt(900) + 100;
		int lineNumber = random.nextInt(9000) + 1000;
		return String.format("%03d03d04d", areaCode, exchangeCode, lineNumber);
	}

	private static final String[] cities = { "New York City, New York", "Los Angeles, California", "Chicago, Illinois",
			"Houston, Texas", "Phoenix, Arizona", "Philadelphia, Pennsylvania", "San Antonio, Texas",
			"San Diego, California", "Dallas, Texas", "San Jose, California", "Austin, Texas", "Jacksonville, Florida",
			"San Francisco, California", "Indianapolis, Indiana", "Columbus, Ohio", "Fort Worth, Texas",
			"Charlotte, North Carolina", "Seattle, Washington", "Denver, Colorado", "Washington, D.C.",
			"Boston, Massachusetts", "El Paso, Texas", "Nashville, Tennessee", "Detroit, Michigan",
			"Oklahoma City, Oklahoma", "Portland, Oregon", "Las Vegas, Nevada", "Memphis, Tennessee",
			"Louisville, Kentucky", "Baltimore, Maryland", "Milwaukee, Wisconsin", "Albuquerque, New Mexico",
			"Tucson, Arizona", "Fresno, California", "Sacramento, California", "Mesa, Arizona", "Kansas City, Missouri",
			"Atlanta, Georgia", "Long Beach, California", "Colorado Springs, Colorado", "Raleigh, North Carolina",
			"Miami, Florida", "Virginia Beach, Virginia", "Omaha, Nebraska", "Oakland, California",
			"Minneapolis, Minnesota", "Tulsa, Oklahoma", "Wichita, Kansas", "New Orleans, Louisiana",
			"Arlington, Texas", "Cleveland, Ohio", "Tampa, Florida", "Bakersfield, California", "Aurora, Colorado",
			"Honolulu, Hawaii", "Anaheim, California", "Santa Ana, California", "Riverside, California",
			"Corpus Christi, Texas", "Lexington, Kentucky", "Stockton, California", "St. Paul, Minnesota",
			"Cincinnati, Ohio", "Anchorage, Alaska", "Toledo, Ohio", "Newark, New Jersey", "Greensboro, North Carolina",
			"Plano, Texas", "Henderson, Nevada", "Lincoln, Nebraska", "Buffalo, New York", "Fort Wayne, Indiana",
			"Jersey City, New Jersey", "Chula Vista, California", "Orlando, Florida", "St. Petersburg, Florida",
			"Norfolk, Virginia", "Chandler, Arizona", "Laredo, Texas", "Madison, Wisconsin", "Durham, North Carolina",
			"Lubbock", };

	public String generateRandomCities() {
		String cities2 = "";
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			String cities1 = cities[random.nextInt(cities.length)];
			cities2 = cities1;
		}
		return cities2;
	}

	private static final String[] termsAndConditions = {
			"By accessing and using our services, you agree to comply with the terms and conditions outlined herein.",
			"You acknowledge that the information provided during registration is accurate and up-to-date.",
			"Use of the services is subject to applicable laws and regulations. Any violation may result in account termination.",
			"You consent to receive communications from us, including updates, promotions, and important announcements.",
			"The services provided are for personal and non-commercial use. Commercial use requires prior written approval.",
			"You agree not to engage in any activity that may disrupt or interfere with the proper functioning of our services.",
			"We reserve the right to modify or terminate services at any time without prior notice.",
			"Users are responsible for maintaining the confidentiality of their account information, including passwords.",
			"Any unauthorized access or use of accounts must be reported immediately for appropriate action.",
			"Your use of the services is at your own risk. We disclaim any warranties or guarantees regarding the accuracy or reliability of the content.",
			"You agree to indemnify and hold us harmless from any claims or liabilities arising from your use of the services.",
			"These terms and conditions may be updated, and continued use of the services constitutes acceptance of any changes.",
			"Disputes will be resolved through arbitration, and you waive the right to participate in class-action lawsuits.",
			"We may collect and process personal data as outlined in our privacy policy.",
			"Governing law: These terms are governed by the laws of [Your Jurisdiction].",
			"For inquiries or concerns regarding these terms, please contact [Your Contact Information]." };

	public String generateRandomTermsAndConditions() {
		String termsAndConditions2 = "";
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			String termsAndConditions1 = termsAndConditions[random.nextInt(termsAndConditions.length)];
			termsAndConditions2 = termsAndConditions1;
		}
		return termsAndConditions2;
	}

	public String getCurrentTimeWithExtraHour() {
		LocalTime currentTime = LocalTime.now();
		LocalTime timeWithExtraHour = currentTime.plusHours(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
		String formattedTime = timeWithExtraHour.format(formatter);
		return formattedTime;
	}

	public String getCurrentTimeWithExtraHourRandom() {
		LocalTime currentTime = LocalTime.now();
		LocalTime timeWithExtraHour = currentTime.plusHours(1);
		int randomMinutes = new Random().nextInt(60);
		int randomSeconds = new Random().nextInt(60);
		timeWithExtraHour = timeWithExtraHour.withMinute(randomMinutes).withSecond(randomSeconds);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
		String formattedTime = timeWithExtraHour.format(formatter);
		return formattedTime;
	}

	public LocalTime getTheTimeForMintuesGap(String targetTimeString, int min) {
		LocalTime targetTime = LocalTime.parse(targetTimeString);
		Duration gapDuration = Duration.ofMinutes(min);
		LocalTime nextTime = targetTime.plus(gapDuration);
		return nextTime;
	}

	private static final String[] GENDERS = { "male", "female", };

	public String generateRandomGenders() {
		Random random = new Random();
		String gender = GENDERS[random.nextInt(GENDERS.length)];
		return gender;
	}

	public String generateDatesForTheNext30Days() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = null;
		for (int i = 0; i < 30; i++) {
			LocalDate date = currentDate.plusDays(i);
			if (!date.isBefore(currentDate)) {
				formattedDate = date.format(formatter);
			}
		}
		return formattedDate;
	}

	private String[] first_Names = { "AARYA", "ADITHI", "AKHIL", "ANANYA", "ANIRUDH", "ANUSHA", "ARAVIND", "BHAGYA",
			"CHAITANYA", "DEVIKA", "DHANUSH", "DIVYA", "EKANSH", "GANESH", "GAYATHRI", "HARI", "ISHITA", "JANANI",
			"KARTHIK", "KRITHIKA", "MITHUN", "NANDINI", "NAREN", "NITHYA", "Joe", "PADMA", "PRAVIN", "PREETI", "RAJESH",
			"RAJANI", "RITHVIK", "SAKSHI", "SAMUEL", "SANJANA", "SHANKAR", "SHREYA", "SIDDARTH", "SINDHU", "SUMIT",
			"SWATHI", "TANVI", "TARUN", "TRISHA", "UDAY", "UDITA", "VASU", "VARSHA", "VIDYUTH", "VIJAY", "VISHAKHA",
			"YOGI", "YAMINI", "ZARA", "AISHWARYA", "AMAR", "AMRITA", "ALAGAPPAN", "ANAND", "AKSHARA", "ARJUN", "ARATI",
			"ASHWIN", "AARADHYA", "ANIRBAN", "ABHIGNA", "ASHOK", "BALA", "BHARATHI", "CHANDRA", "CHINMAY", "DEEPTI",
			"DINESH", "GAURI", "GIRISH", "HARINI", "ISHAN", "JANHVI", "JAGADEESH", "KAVYA", "KIRAN", "LAKSHMI",
			"MADHAV", "MEENAKSHI", "MUKUND", "NANDHINI", "NIRMALA", "OMKARA", "PADMAPRIYA", "PRADEEP", "PRAKRITI",
			"RAHUL", "RUKMINI", "RAGHAV", "SANDHYA", "SANTHOSH", "SHRUTHI", "SUSHANT", "SWARNA", "TARAK", "TANUSHREE",
			"UDAYAN", "VANDANA", "VINEETH" };

	private String[] middle_Names = { "RAJAN", "NAIR", "NAIK", "NAMBOODIRI", "RAO", "REDDY", "MENON", "PILLAI", "KURUP",
			"KUMARAN", "SHETTY", "SHARMA", "SHET", "SHENOY", "PRABHU", "PADMANABHAN", "NAMBIAR", "MOHAN", "MISHRA",
			"MEHTA", "VENKATESH", "VENKATARAMAN", "VENUGOPAL", "KRISHNAN", "KRISHNAKUMAR", "KRISHNAMURTHY", "ANAND",
			"ANANTH", "BALAN", "BALASUBRAMANIAN", "BALAKRISHNAN", "SURESH", "RAJESH", "RAMESH", "NAGESH", "NARENDRA",
			"NARAYANAN", "SUDHAKAR", "SUBRAMANIAN", "SUNDAR", "SUNDARAM", "SUNIL", "MURALI", "MURTHY", "VENUGOPAL",
			"VIJAY", "VIKRAM", "RAGHAVAN", "RAMAN", "RAMANAN", "RAVI", "RAJU", "RAMESH", "RAGHU", "RAJAN", "RAO",
			"RAJAGOPAL", "RADHAKRISHNAN", "RADHAKRISHNA", "RADHAKRISHNAMURTHY", "DASARI", "DASARATHY", "DASGUPTA",
			"DASH", "DAS", "DASTIDAR", "DATTA", "DATTATREYA", "DEVARAKONDA", "DEVAREDDY", "DEY", "DHAIRYASHIL", "DHAL",
			"DHAMI", "DHEERAJ", "DHIRAJ", "DHIRENDRA", "DHRUV", "DHULIPALA", "DILIP", "DINAKARAN", "DINESH", "DINODIA",
			"DODDA", "DOGRA", "DORAIRAJ", "DUA", "DUBASH", "DUBEY", "DUGGAL" };

	private String[] last_Names = { "A", "B", "C", "D", "E", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "U",
			"V", "W", "Y" };

	public String generateRandomNames(WebDriver driver) {
		Random random = new Random();
		String first = first_Names[random.nextInt(first_Names.length)];
		String second = middle_Names[random.nextInt(middle_Names.length)];
		String last = last_Names[random.nextInt(last_Names.length)];
		return first + " " + second + " " + last;
	}

	private static final Faker faker = new Faker();

	public static String getRandomImageUrl_JavaFaker() {
		String randomImagePath = faker.internet().image();
		return randomImagePath;
	}

	public static String generateRandomTitle_JavaFaker() {
		return faker.lorem().sentence();
	}

	public static String generateRandomContent_JavaFaker() {
		Faker faker = new Faker();
		String loremIpsum1 = faker.lorem().sentence();
		String loremIpsum2 = faker.lorem().sentence();
		String loremIpsum3 = faker.lorem().sentence();
		return loremIpsum1 + loremIpsum2 + loremIpsum3;
	}

	public static String generateRandomName_JavaFaker() {
		return faker.name().fullName();
	}

	public static String generateRandomUrl_JavaFaker() {
		return faker.internet().url();
	}

	private String[] image_url = { "./src/main/resources/CommanData/Document/productImage.png",
			"./src/main/resources/CommanData/Document/bi1.png", "./src/main/resources/CommanData/Document/bi2.jpg",
			"./src/main/resources/CommanData/Document/bi3.png", "./src/main/resources/CommanData/Document/bi5.jpg",
			"./src/main/resources/CommanData/Document/bi9.jpg",
			"./src/main/resources/CommanData/Document/download (1).png" };

	public String randomImage() {
		Random random = new Random();
		String image = image_url[random.nextInt(image_url.length)];
		String absoluteFilePath = new File(image).getAbsolutePath();
		return absoluteFilePath;
	}

	public static String generateTemplateName_JavaFaker() {
		return faker.lorem().word();
	}

	public static String generateTemplateContent_JavaFaker() {
		return faker.lorem().paragraph();
	}

	private static final String[] PREFIXES = { "Smart Solutions", "Tech Industries", "Global Corp",
			"Innovative Services", "ABC Solutions", "Mega Ltd", "Dynamic Industries", "Prime Corp", "Star Solutions",
			"Global Ltd", "Tech Corp", "Alpha Solutions", "Innovative Ltd", "Strategic Industries", "Power Solutions",
			"Ultra Corp", "Eco Industries", "ABC Services", "Pro Corp", "NexGen Industries", "Smart Services",
			"Strategic Solutions", "Power Ltd", "Star Industries", "Innovative Services", "Smart Ltd",
			"Dynamic Solutions", "ABC Industries", "Tech Ltd", "Mega Services", "NexGen Solutions", "Global Services",
			"Strategic Ltd", "Alpha Industries", "Dynamic Ltd", "Prime Solutions", "Power Industries", "Eco Solutions",
			"Ultra Services", "Innovative Industries", "Mega Corp", "Alpha Services", "ABC Corp", "Smart Industries",
			"Pro Services", "Prime Ltd", "NexGen Corp", "Eco Corp", "Global Solutions", "Star Ltd",
			"Strategic Services", "Tech Services", "Pro Ltd", "Ultra Industries", "NexGen Services", "Power Services",
			"Innovative Corp", "Alpha Corp", "Dynamic Corp", "Mega Industries", "Eco Services", "Smart Corp",
			"Global Industries", "Star Corp", "Prime Industries", "ABC Ltd", "Innovative Ltd", "Tech Corp",
			"NexGen Ltd", "Power Corp", "Pro Industries", "Strategic Corp", "Dynamic Services", "Eco Ltd",
			"Mega Solutions", "Ultra Ltd", "Alpha Solutions", "Smart Services", "Star Industries", "ABC Services",
			"Prime Corp", "Power Ltd", "Global Solutions", "Innovative Services", "Tech Solutions", "NexGen Corp",
			"Pro Services", "Eco Solutions", "Mega Ltd", "Ultra Industries", "Strategic Ltd", "Alpha Industries",
			"Dynamic Corp", "Smart Industries", "Global Corp", "Power Industries", "ABC Corp", "Innovative Ltd",
			"Star Solutions", "Tech Ltd" };
	private static final String[] SUFFIXES = { "ABC Corp", "Innovative Solutions", "Smart Industries", "XYZ Ltd",
			"Global Services", "Tech Industries", "Innovative Ltd", "ABC Services", "Smart Industries",
			"Tech Solutions", "Innovative Industries", "XYZ Corp", "Tech Industries", "ABC Solutions", "Global Ltd",
			"Innovative Corp", "XYZ Solutions", "ABC Industries", "Global Solutions", "Tech Ltd", "Smart Services",
			"Innovative Solutions", "XYZ Industries", "Global Corp", "Smart Industries", "Innovative Corp",
			"ABC Services", "Tech Solutions", "XYZ Industries", "Global Services", "Innovative Ltd", "Smart Industries",
			"ABC Solutions", "Tech Corp", "Innovative Services", "XYZ Ltd", "Global Solutions", "Tech Services",
			"Smart Solutions", "Innovative Industries", "ABC Corp", "XYZ Solutions", "Global Ltd", "Tech Industries",
			"Smart Industries", "Innovative Corp", "ABC Solutions", "Tech Ltd", "XYZ Services", "Global Industries",
			"Innovative Solutions", "Smart Industries", "ABC Services", "XYZ Corp", "Tech Industries", "Innovative Ltd",
			"Global Corp", "Smart Solutions", "ABC Corp", "Tech Services", "XYZ Industries", "Innovative Solutions",
			"Smart Ltd", "ABC Solutions", "Global Industries", "Tech Solutions", "XYZ Corp", "Innovative Corp",
			"Smart Services", "ABC Industries", "Global Solutions", "Tech Ltd", "Innovative Industries", "XYZ Services",
			"Smart Corp", "ABC Ltd", "Global Ltd", "Tech Services", "Innovative Services", "XYZ Solutions",
			"Smart Industries", "ABC Services", "Tech Industries", "Innovative Ltd", "Global Services", "XYZ Ltd",
			"Smart Solutions" };

	public String generateRandomVendorName() {
		Random random = new Random();
		String randomPrefix = PREFIXES[random.nextInt(PREFIXES.length)];
		String randomSuffix = SUFFIXES[random.nextInt(SUFFIXES.length)];
		return randomPrefix + " " + randomSuffix;
	}
	
}
