package voting.categories;

public class PresidentVote extends VoteCategory {
    public PresidentVote() {
        super(new String[]{"Alice", "Bob"});
    }

    @Override
    public String getCategoryName() {
        return "President";
    }
}
