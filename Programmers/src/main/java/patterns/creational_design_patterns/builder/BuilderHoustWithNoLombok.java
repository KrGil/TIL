package patterns.creational_design_patterns.builder;

/**
 * packageName :  patterns.creational_design_patterns.builder
 * fileName : BuilderHoustWithNoLombok
 * author :  eisen
 * date : 2022/04/22
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/22                eisen             최초 생성
 */
public class BuilderHoustWithNoLombok {
    private int windows;
    private boolean hasGarden;

    public static class Builder{
        private int windows;
        private boolean hasGarden;

        public Builder windows(int windows) {
            this.windows = windows;
            return this;
        }

        public Builder hasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }
        public BuilderHoustWithNoLombok build(){
            return new BuilderHoustWithNoLombok(this);
        }

    }
   private BuilderHoustWithNoLombok(Builder builder){
        this.windows = builder.windows;
        this.hasGarden = builder.hasGarden;
   }

   public void updateWindows(int windows){
        this.windows = windows;
   }

}
