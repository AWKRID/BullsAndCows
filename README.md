# 숫자 야구 게임기
---
## 🔍프로젝트 소개 
---
- **숫자야구**게임을 할 수 있는 프로그램 입니다.
- 직접 난이도를 설정하여 게임을 진행하며, 게임 기록을 볼 수 있습니다.

## 💻사용 예시 
--- 
### 1. 프로그램 시작 시 메뉴
```
--------------------------------------
환영합니다! 원하시는 번호를 입력해주세요.
현재 난이도: Lv.1
1. 게임 시작하기
2. 게임 기록 보기
3. 난이도 변경하기
4. 종료하기
--------------------------------------
```

### 2. 게임 시작하기
0~9까지의 숫자를 사용해 숫자야구 게임을 진행합니다.
숫자는 중복될 수 없고, 0이 제일 처음에 오는 경우는 없습니다.
```
<게임을 시작합니다>
숫자를 입력하세요
123
1S
--------------------------------------
숫자를 입력하세요
456
1S
--------------------------------------
숫자를 입력하세요
789
1S
--------------------------------------
숫자를 입력하세요
159
Out!
--------------------------------------
숫자를 입력하세요
483
정답입니다!

```

### 3. 게임 기록 보기
현재까지 진행한 게임 기록을 볼 수 있습니다. 
```
<게임 기록 보기>
--------------------------------------
1번째 게임(Lv.1) : 시도 횟수 - 5
2번째 게임(Lv.1) : 시도 횟수 - 6
3번째 게임(Lv.1) : 시도 횟수 - 4
--------------------------------------
```

### 4. 난이도 변경하기
Lv1 부터 Lv4까지 난이도를 변경하면서 진행할 수 있습니다. 
```
<난이도 변경하기>
1. 3자리 숫자
2. 4자리 숫자
3. 5자리 숫자
4. 6자리 숫자
메인메뉴로 돌아가려면 이외의 키를 입력해주세요.
--------------------------------------
2
현재 난이도가 [4자리 숫자]로 변경됩니다. 
```

## 구현사항
--- 
### 1. 필수 구현 사항
**입출력**
[x] 서로 다른 3자리 수 입력(각 자리수는 1~9)
[x] 입력한 수에 대한 결과를 B, S, Out 으로 구분하여 표시

**요구사항**
[x] 올바르지 않은 입력에 대해서 오류 문구 출력
[x] 정답이 입력될 경우 게임 종료

### 2. 선택 구현 기능
---
[x] 프로그램을 시작할 때 안내문구 표시
[x] 정답을 맞혀 게임이 종료된 경우 안내문구 다시 표시
---
[x] 정답이 되는 숫자를 0~9로 확장. (맨 앞자리에 0이 오는 경우는 제외)
---
[x] 실행 시, 2번 게임 기록 보기의 경우 완료한 게임들에 대해 시도 횟수를 보여주기
[x] 종료하기를 누를 경우 프로그램 종료
[x] 안내 문구에 표시된 번호 이외의 입력에 대해서 오류 메시지 표기

### 3. 추가 구현 기능
---
[x] 난이도 설정 기능 추가 
- Lv1. 3자리 숫자
- Lv2. 4자리 숫자
- Lv3. 5자리 숫자
- Lv4. 6자리 숫자

[x] 게임 기록 출력 시 해당 게임의 난이도와 시도 횟수를 같이 출력
