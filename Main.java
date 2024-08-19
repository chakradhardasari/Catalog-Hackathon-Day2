import java.util.*;

class Question {
    private String state;
    private String capital;

    public Question(String state, String capital) {
        this.state = state;
        this.capital = capital;
    }

    public String getState() {
        return state;
    }

    public String getCapital() {
        return capital;
    }
}

class Quiz {
    private List<Question> questions;
    private Map<String, Integer> leaderboard;

    public Quiz() {
        questions = new ArrayList<>();
        leaderboard = new HashMap<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        questions.add(new Question("Andhra Pradesh", "Amaravati"));
        questions.add(new Question("Arunachal Pradesh", "Itanagar"));
        questions.add(new Question("Assam", "Dispur"));
        questions.add(new Question("Bihar", "Patna"));
        questions.add(new Question("Chhattisgarh", "Raipur"));
        questions.add(new Question("Goa", "Panaji"));
        questions.add(new Question("Gujarat", "Gandhinagar"));
        questions.add(new Question("Haryana", "Chandigarh"));
        questions.add(new Question("Himachal Pradesh", "Shimla"));
        questions.add(new Question("Jharkhand", "Ranchi"));
        questions.add(new Question("Karnataka", "Bengaluru"));
        questions.add(new Question("Kerala", "Thiruvananthapuram"));
        questions.add(new Question("Madhya Pradesh", "Bhopal"));
        questions.add(new Question("Maharashtra", "Mumbai"));
        questions.add(new Question("Manipur", "Imphal"));
        questions.add(new Question("Meghalaya", "Shillong"));
        questions.add(new Question("Mizoram", "Aizawl"));
        questions.add(new Question("Nagaland", "Kohima"));
        questions.add(new Question("Odisha", "Bhubaneswar"));
        questions.add(new Question("Punjab", "Chandigarh"));
        questions.add(new Question("Rajasthan", "Jaipur"));
        questions.add(new Question("Sikkim", "Gangtok"));
        questions.add(new Question("Tamil Nadu", "Chennai"));
        questions.add(new Question("Telangana", "Hyderabad"));
        questions.add(new Question("Tripura", "Agartala"));
        questions.add(new Question("Uttar Pradesh", "Lucknow"));
        questions.add(new Question("Uttarakhand", "Dehradun"));
        questions.add(new Question("West Bengal", "Kolkata"));
    }

    public void startQuiz(String participant) {
        System.out.println("Starting quiz for: " + participant);
        Collections.shuffle(questions);
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) { // Asking 5 random questions
            Question q = questions.get(i);
            System.out.println("What is the capital of " + q.getState() + "?");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase(q.getCapital())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + q.getCapital());
            }
        }

        leaderboard.put(participant, score);
        System.out.println("Quiz completed! " + participant + "'s score: " + score);
    }

    public void displayLeaderboard() {
        System.out.println("Leaderboard:");
        leaderboard.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " points"));
    }
}

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Smart Assessment Board!");
        System.out.println("Enter the number of participants: ");
        int participantsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < participantsCount; i++) {
            System.out.println("Enter participant name: ");
            String participantName = scanner.nextLine();
            quiz.startQuiz(participantName);
        }

        quiz.displayLeaderboard();
    }
}
