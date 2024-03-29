import java.util.ArrayList;
import java.util.Date;

public class JobPosting{

    private Date datePosted;
    private Date dateClosed;
    private String position;
    private HiringPool candidatePool;
    private int interviewRounds;
    protected ArrayList<Applicant> applicants = new ArrayList<>();

    public JobPosting(Date datePosted, Date dateClosed, String position, int interviewRounds) {
        this.datePosted = datePosted;
        this.dateClosed = dateClosed;
        this.position = position;
        this.interviewRounds = interviewRounds;
    }

    public Date getDatePosted() { return this.datePosted; }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public Date getDateClosed() {
        return this.dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public HiringPool getCandidatePool(){
        return this.candidatePool;
    }

    //HR needs to have access to this information as well.
    public void addApplicant (Applicant applicant){
        boolean flag = false;
        for(Applicant a: this.applicants) {
            if ((a.getUsername().equals(applicant.getUsername()))) {
                flag = true;
            }
        }
        if(!flag){
            this.applicants.add(applicant);
            this.candidatePool.addToPool(applicant, 0); //initial status
        }
    }

    public String viewApplicants(){
        String listOfApplicants = "";
        String result;
        for (Applicant applicant: this.applicants){
            listOfApplicants = listOfApplicants + applicant.getUsername() + ",";
        }
        if (listOfApplicants.length() ==0){result = listOfApplicants;}
        else {result = listOfApplicants.substring(0, listOfApplicants.length()-1);} //takes off the last comma
        return result;
    }


}
