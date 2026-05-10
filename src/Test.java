import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Team liverpol = new Team();
        liverpol.liverpool();
    }
}

class Team {

    void liverpool(){
        Alisson alisson = new Alisson();
        alisson.information();
        alisson.training();

        AlexanderArnold alexanderArnold = new AlexanderArnold();
        alexanderArnold.information();
        alexanderArnold.training();

        Konate konate = new Konate();
        konate.information();
        konate.training();

        VanDijk vanDijk = new VanDijk();
        vanDijk.information();
        vanDijk.training();

        Robertson robertson = new Robertson();
        robertson.information();
        robertson.training();

        Henderson henderson = new Henderson();
        henderson.information();
        henderson.training();

        Thiago thiago = new Thiago();
        thiago.information();
        thiago.training();

        Salah salah = new Salah();
        salah.information();
        salah.training();

        Mane mane = new Mane();
        mane.information();
        mane.training();

        Diaz diaz = new Diaz();
        diaz.information();
        diaz.training();

        Fabinho fabinho = new Fabinho();
        fabinho.information();
        fabinho.training();
    }
}

// ─── 선수 개별 클래스 ───────────────────────────────────────

class Alisson {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player alisson = new Player();
        alisson.physical(191, 91);
        alisson.Stats();
        alisson.setSelect(new Goalkeeper());
        alisson.doSetting();
    }
    void training() {
        TrainingClass alisson = new PerTrainingClass();
        alisson.keepertrain();
    }
}

class AlexanderArnold {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player alexanderarnold = new Player();
        alexanderarnold.physical(180, 72);
        alexanderarnold.Stats();
        alexanderarnold.setSelect(new Defender());
        alexanderarnold.doSetting();
    }
    void training() {
        TrainingClass alexanderarnold = new PerTrainingClass();
        alexanderarnold.offendeffentrain();
    }
}

class Konate {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player konate = new Player();
        konate.physical(194, 95);
        konate.Stats();
        konate.setSelect(new Defender());
        konate.doSetting();
    }
    void training() {
        TrainingClass konate = new PerTrainingClass();
        konate.offendeffentrain();
    }
}

class VanDijk {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player vandijk = new Player();
        vandijk.physical(193, 92);
        vandijk.Stats();
        vandijk.setSelect(new Defender());
        vandijk.doSetting();
    }
    void training() {
        TrainingClass vandijk = new PerTrainingClass();
        vandijk.offendeffentrain();
    }
}

class Robertson {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player robertson = new Player();
        robertson.physical(178, 64);
        robertson.Stats();
        robertson.setSelect(new Defender());
        robertson.doSetting();
    }
    void training() {
        TrainingClass robertson = new PerTrainingClass();
        robertson.offendeffentrain();
    }
}

class Henderson {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player henderson = new Player();
        henderson.physical(188, 84);
        henderson.Stats();
        henderson.setSelect(new Forward());
        henderson.doSetting();
    }
    void training() {
        TrainingClass henderson = new PerTrainingClass();
        henderson.offendeffentrain();
    }
}

class Thiago {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player thiago = new Player();
        thiago.physical(174, 70);
        thiago.Stats();
        thiago.setSelect(new Forward());
        thiago.doSetting();
    }
    void training() {
        TrainingClass thiago = new PerTrainingClass();
        thiago.offendeffentrain();
    }
}

class Salah {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player salah = new Player();
        salah.physical(175, 71);
        salah.Stats();
        salah.setSelect(new Forward());
        salah.doSetting();
    }
    void training() {
        TrainingClass salah = new PerTrainingClass();
        salah.offendeffentrain();
    }
}

class Mane {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player mane = new Player();
        mane.physical(175, 69);
        mane.Stats();
        mane.setSelect(new Forward());
        mane.doSetting();
    }
    void training() {
        TrainingClass mane = new PerTrainingClass();
        mane.offendeffentrain();
    }
}

class Diaz {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player diaz = new Player();
        diaz.physical(180, 73);
        diaz.Stats();
        diaz.setSelect(new Forward());
        diaz.doSetting();
    }
    void training() {
        TrainingClass diaz = new PerTrainingClass();
        diaz.offendeffentrain();
    }
}

class Fabinho {
    void information() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("이름: " + className);
        Player fabinho = new Player();
        fabinho.physical(188, 78);
        fabinho.Stats();
        fabinho.setSelect(new Forward());
        fabinho.doSetting();
    }
    void training() {
        TrainingClass fabinho = new PerTrainingClass();
        fabinho.offendeffentrain();
    }
}

// ─── 디자인 패턴 구현 ─────────────────────────────────────────

// Template Method Pattern - 훈련 클래스
abstract class TrainingClass {
    protected abstract void keeper();
    protected abstract void offendefen();

    public void keepertrain() {
        keeper();
        System.out.println("1.스텝 훈련\n2.다이빙 훈련");
        System.out.println(" ");
        System.out.println("=================================");
        System.out.println(" ");
    }

    public void offendeffentrain() {
        offendefen();
        System.out.println("1.콘 런\n2.저글링");
        System.out.println(" ");
        System.out.println("=================================");
        System.out.println(" ");
    }
}

class PerTrainingClass extends TrainingClass {
    protected void keeper() { System.out.println("골키퍼 훈련"); }
    protected void offendefen() { System.out.println("공격수/수비수 훈련"); }
}

// Strategy Pattern - 포지션별 장비 세팅
class Player {
    private Position position;

    public void setSelect(Position position) { this.position = position; }
    public void doSetting() { position.setting(); }

    void physical(int tall, int weight) {
        System.out.println("키: " + tall);
        System.out.println("몸무게: " + weight);
    }

    void Stats() {
        Stat offstatAnddefenstat =
                new DefensiveStat(
                        new OffensiveStat(
                                new TeamName()));
        offstatAnddefenstat.stat();
    }
}

abstract class Position {
    public abstract void setting();
}

class Goalkeeper extends Position {
    public void setting() { System.out.println("포지션: 골키퍼 - 신발 유니폼 장갑"); }
}

class Forward extends Position {
    public void setting() { System.out.println("포지션: 공격수 - 신발 유니폼"); }
}

class Defender extends Position {
    public void setting() { System.out.println("포지션: 수비수 - 신발 유니폼"); }
}

// Decorator Pattern - 선수 능력치 레이어링
abstract class Stat {
    public abstract void stat();
}

class TeamName extends Stat {
    public void stat() { System.out.println("팀: 리버풀"); }
}

abstract class PlayerStat extends Stat {
    private final Stat statedplayer;
    public PlayerStat(Stat statedplayer) { this.statedplayer = statedplayer; }
    public void stat() { statedplayer.stat(); }
}

class OffensiveStat extends PlayerStat {
    public OffensiveStat(Stat statedplayer) { super(statedplayer); }
    public void stat() {
        super.stat();
        System.out.println("공격력 점수:" + (new Random().nextInt(10) + 1));
    }
}

class DefensiveStat extends PlayerStat {
    public DefensiveStat(Stat statedplayer) { super(statedplayer); }
    public void stat() {
        super.stat();
        System.out.println("수비력 점수:" + (new Random().nextInt(10) + 1));
    }
}
