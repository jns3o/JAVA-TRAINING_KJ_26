package practice.test260715;
//
public class Player {//player클래스는 메인메서드가 있는 play클래스에서 객체생성 후 메서드 호출로 쓰기 위해 일반 클래스로 생성
	
    String name; //메인에서 유저와 컴퓨터 각각의 값을 저장하기 위해서 player클래스를 생성 후 유저와 컴퓨터라는 각각의 주소를 구분하기 위해서 String name;작성
     int score; //메인에서 유저와 컴퓨터 각각의 스코어를 저장하기 위해 스코어 필드생성
     int count; //score와 동일
     
    
    Player(String name) {//메인에서 "유저"와"컴퓨터"로 두개의 주소지를 만들었는데 필드에서 String형으로 name을 만들어뒀고 메인에서 new player("유저")이렇게 생성했기에 player(유저),(컴퓨터)로 각각 저장됨
        this.name = name; //this. 을 찍어서 메인에서 호출했을때 user와 com을 구별하지 못해 오류가 나는 걸 막기위해 각 객체를 가리키는 변수
        this.score = 0; //만약 참조변수 this.을 찍지 않으면 player클래스에서 에러가 뜨거나 메인에서 엉뚱한 값이 출력 될 수 있음
        this.count = 0; // + this변수를 쓰지않고 작성을 하게 되면 com과 유저 객체 각각의 변수를 만들어줘야 하므로 현재의 양에서 2배로 늘어나게됨
    }

    
    void addScore(int plusScore) {
        this.score += plusScore; //메인에서 addScore를 호출하면 소괄호안에 있는 숫자를 받게 되므로 이번 라운드에서의 값을 score에 누적으로 더함
    }

    void addCount() {
        this.count++; //while문이 한 바퀴 돌때마다 count가 도는걸 표시해주기 위한 메서드이다
    }
    int getScore() { return score; }//메인에서 getScore나 Count를 호출했을때 com과 user각 주소에 저장된 count나 score의 값을 반환해주기 위한 메서드
    int getCount() { return count; }
}

