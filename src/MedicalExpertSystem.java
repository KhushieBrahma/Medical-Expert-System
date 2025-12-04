import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalExpertSystem {
 static class Recommendation {
  String conditionGuess;
  String medicineCategory;
  String generalAdvice;
 }

 public static void main(String[] args){
  Scanner sc = new Scanner(System.in);
  System.out.println("=======================================");
  System.out.println("     MEDICAL EXPERT SYSTEM (DEMO)      ");
  System.out.println("=======================================");
  System.out.println("⚠ This is an educational project only.");
  System.out.println("⚠ Not for real medical diagnosis or treatment.\n");

  boolean again = true;

  while (again){
    List<Integer> selectedSymptoms = getUserSymptoms(sc);

    if (selectedSymptoms.isEmpty()){
     System.out.println("\nNo symptoms selected. Please try again.");
    } else {
     Recommendation rec = runRuleEngine(selectedSymptoms);
     displayResult(rec);
    }
    System.out.println("\nDo you want to check for another case? (y/n)");
    char c = sc.next().toLowerCase().charAt(0);
    again = (c == 'y');
  }
  System.out.println("\nDo you want to check for another case? (y/n)");
  System.out.println("Always consult a real doctor for health issues.");
  sc.close();
 }
 private static List<Integer> getUserSymptoms(Scanner sc) {
   List<Integer> symptoms = new ArrayList<>();

   System.out.println("Please select your symptoms (enter 0 when done):");
   System.out.println(" 1) Fever");
   System.out.println(" 1) Fever");
   System.out.println(" 2) Cough");
   System.out.println(" 3) Headache");
   System.out.println(" 4) Sore throat");
   System.out.println(" 5) Runny / blocked nose");
   System.out.println(" 6) Stomach pain");
   System.out.println(" 7) Nausea");
   System.out.println(" 8) Skin rash or itching");
   System.out.println(" 9) Body pain / muscle pain");
   System.out.println(" 0) Done");
   while (true){
    System.out.print("Enter option (0 to finish): ");
    int choice;

    try{
     choice = sc.nextInt();
    } catch (Exception e){
     sc.nextLine();
     System.out.println("Invalid input. Please enter a number between 0 and 9.");
     continue;
    }
    if (choice == 0){
     break;
    }
     if (choice < 0 || choice > 9){
      System.out.println("Please enter a valid option between 0 and 9.");
     } else{
      if (!symptoms.contains(choice)){
       symptoms.add(choice);
      }else{
       System.out.println("You already selected that symptom.");
      }
     }
   }
   return symptoms;
 }
 private static Recommendation runRuleEngine(List<Integer> symptoms){
   Recommendation rec = new Recommendation();

   boolean fever = symptoms.contains(1);
   boolean cough = symptoms.contains(2);
   boolean headache = symptoms.contains(3);
   boolean soreThroat = symptoms.contains(4);
   boolean coldNose = symptoms.contains(5);
   boolean stomachPain = symptoms.contains(6);
   boolean nausea = symptoms.contains(7);
   boolean skinRash = symptoms.contains(8);
   boolean bodyPain = symptoms.contains(9);

   if (fever && cough && (soreThroat || coldNose)){
    rec.conditionGuess = "Cold / flu-like illness (suspected)";
    rec.medicineCategory ="Fever & pain management, cough relief, and throat soothing agents.";
    rec.generalAdvice =
                    "- Rest and drink plenty of fluids \n" +
                    "- Use general fever/pain relief and cough-relief preparations if suitable.\n" +
                    "- If symptoms are severe, long-lasting, or you have other conditions,\n" +
                    "  please consult a doctor immediately.";
   }
   else if (fever && headache && bodyPain){
    rec.conditionGuess = "Viral fever-like condition (suspected)";
    rec.medicineCategory =
                    "Fever reducers and mild pain relief medicines.";
    rec.generalAdvice =
                    "- Monitor temperature regularly.\n" +
                    "- Take rest and stay hydrated.\n" +
                    "- Seek medical advice if fever is high, persistent, or if you feel very weak.";
   }
   else if (headache && !fever && !cough && !soreThroat && !coldNose && !stomachPain && !nausea && !skinRash){
    rec.conditionGuess = "Primary headache / migraine-like (suspected)";
    rec.medicineCategory =
                    "Mild pain relief / headache relief category.";
    rec.generalAdvice =
                    "- Rest in a quiet, dark room.\n" +
                    "- Avoid screen time temporarily.\n" +
                    "- If headaches are frequent, severe, or accompanied by other symptoms,\n" +
                    "  consult a doctor or neurologist.";
   }
   else if (stomachPain && nausea){
    rec.conditionGuess = "Gastric / indigestion-like issue (suspected)";
    rec.medicineCategory =
                    "Digestive support / acidity control / anti-nausea category.";
    rec.generalAdvice =
                    "- Avoid heavy, oily, or spicy food.\n" +
                    "- Drink small sips of water.\n" +
                    "- If vomiting, blood in stool, or very sharp pain occurs,\n" +
                    "  go to a hospital or doctor immediately.";
   }
   else if (skinRash && !fever && !stomachPain){
    rec.conditionGuess = "Mild allergy / skin irritation-like (suspected)";
    rec.medicineCategory =
                    "Anti-allergy / soothing skin preparations.";
    rec.generalAdvice =
                    "- Avoid known triggers like certain foods, creams, or soaps.\n" +
                    "- Do not scratch excessively.\n" +
                    "- If rash spreads, you have breathing difficulty, or swelling of lips/face,\n" +
                    "  seek emergency medical help.";
   }
   else{
    rec.conditionGuess = "Unclear / mixed symptoms";
    rec.medicineCategory =
                    "No specific category can be safely suggested.";
    rec.generalAdvice =
                    "- Your symptoms do not clearly match a simple pattern in this demo system.\n" +
                    "- Please consult a doctor for proper diagnosis and treatment.\n" +
                    "- Do not self-medicate for serious symptoms.";
   }
   return rec;
 }
 private static void displayResult(Recommendation rec){
    System.out.println("\n=======================================");
    System.out.println("           SYSTEM RECOMMENDATION       ");
    System.out.println("=======================================");
    System.out.println("Possible condition (rough guess):");
    System.out.println("  " + rec.conditionGuess);
    System.out.println("\nSuggested medicine CATEGORY (only general type):");
    System.out.println("  " + rec.medicineCategory);
    System.out.println("\nGeneral advice:");
    System.out.println(rec.generalAdvice);
    System.out.println("\n⚠ This is an academic demo only.");
    System.out.println("⚠ Always consult a qualified medical professional.\n");
 }
}