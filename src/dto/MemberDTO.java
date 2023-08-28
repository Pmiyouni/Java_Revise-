package dto;

    public class MemberDTO {
        private Long id;
        private  String memberEmail;
        private  String memberPassword;
        private  String memberName;
        private  String memberMobile;


        private static long num = 1L;

        public MemberDTO() {

        }

        public MemberDTO(String memberEmail, String memberPassword, String memberName, String memberMobile) {
            this.id = num++;
            this.memberEmail = memberEmail;
            this.memberPassword = memberPassword;
            this.memberName = memberName;
            this.memberMobile = memberMobile;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMemberEmail() {
            return memberEmail;
        }

        public void setMemberEmail(String memberEmail) {
            this.memberEmail = memberEmail;
        }

        public String getMemberPassword() {
            return memberPassword;
        }

        public void setMemberPassword(String memberPassword) {
            this.memberPassword = memberPassword;
        }

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }

        public String getMemberMobile() {
            return memberMobile;
        }

        public void setMemberMobile(String memberMobile) {
            this.memberMobile = memberMobile;
        }

        @Override
        public String toString() {
            return "MemberDTO{" +
                    "id=" + id +
                    ", memberEmail='" + memberEmail + '\'' +
                    ", memberPassword='" + memberPassword + '\'' +
                    ", memberName='" + memberName + '\'' +
                    ", memberMobile='" + memberMobile + '\'' +
                    '}';
        }
    }

