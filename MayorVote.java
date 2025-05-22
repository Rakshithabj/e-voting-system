package voting.categories;

public class MayorVote extends VoteCategory {
    public MayorVote() {
        super(new String[]{"Tom", "Jerry"});
    }

    @Override
    public String getCategoryName() {
        return "Mayor";
    }
}
