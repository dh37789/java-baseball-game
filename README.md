# 숫자 야구 게임

## 진행 방식

- 미션은 기능 요구사항,프로그래밍 요구사항,과제진행 요구사항 세가지로 구성되어 있다.
- 세개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능목록을 만들고, 기능 단위로 commit하는 방식으로 진행한다.
- 기능 요구사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 기능 요구사항

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크,다른 자리에 있으면 볼,같은 수가 전혀 없으면 낫싱이란 힌트를 얻고,그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  - [예]상대방(컴퓨터)의수가425일때,

    1. 123을제시한경우:1스트라이크
    2. 456을제시한경우:1볼1스트라이크
    3. 789를제시한경우:낫싱
  
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.게임플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 게임플레이어가 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

