# 휴먼교육센터 챗봇 프로젝트

## 웹 데이터 크롤링
1. 라이브러리 import 하기
```python
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from datetime import date
import requests
import psycopg2
import time
```
2. 서울안전누리 지하철사고 특보 페이지 크롤링
```python
url = 'C:/Users/User/Desktop/chatbot/'
driver = webdriver.Chrome(url + 'chromedriver.exe')
driver.get("https://safecity.seoul.go.kr/acdnt/sbwyIndex.do")
time.sleep(3)
```
3. 크롤링한 웹페이지에서 지하철 사고 속보 뽑아오기
```python
parentElement = driver.find_elements(By.XPATH, '//*[@id="dv_as_timeline"]/li')

subli=[]

for i in parentElement:
    i.click()
    time.sleep(0.05)
    a = i.text
    subli.append(a)
    print(a)
    print(type(a))
    print()
    
    i.click()

```

4. 사고 속보를 저장할 DB 연결


