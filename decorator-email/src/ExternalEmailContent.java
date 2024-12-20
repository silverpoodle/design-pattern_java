public class ExternalEmailContent extends BasicEmailContent {
    ExternalEmailContent(String content) {
        super(content);
    }
    public String getContent() {
        String content = super.getContent() ;
        String externalContent = addDisclaimer(content);
        return externalContent ;
    }
    private String addDisclaimer(String content) {
        return content + " Company Disclaimer";
    }
}