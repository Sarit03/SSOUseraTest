การติดตั้งและใช้งาน
1. Clone โปรเจกต์
ทำการ clone โปรเจกต์นี้ไปยังเครื่องของคุณ:

bash
คัดลอก
แก้ไข
git clone https://github.com/your-repository/SSOTEST.git
cd SSOTEST
2. ติดตั้ง Dependencies
โปรเจกต์นี้ใช้ Maven ในการจัดการ dependencies, ดังนั้นคุณสามารถติดตั้ง dependencies ได้โดยใช้คำสั่ง:

bash
คัดลอก
แก้ไข
mvn install
3. การตั้งค่าฐานข้อมูล
โปรเจกต์นี้ใช้ฐานข้อมูล PostgreSQL, ดังนั้นคุณต้องตั้งค่า PostgreSQL ให้พร้อมใช้งานและสร้างฐานข้อมูล ssotest ด้วยข้อมูลการเชื่อมต่อที่กำหนดในไฟล์ application.properties:

properties
คัดลอก
แก้ไข
spring.datasource.url=jdbc:postgresql://localhost:5432/ssotest
spring.datasource.username=ssodev
spring.datasource.password=sso2022ok
spring.datasource.driver-class-name=org.postgresql.Driver
4. การรันแอปพลิเคชัน
คุณสามารถรันแอปพลิเคชันด้วยคำสั่ง:

bash
คัดลอก
แก้ไข
mvn spring-boot:run
โปรเจกต์จะเริ่มทำงานที่ http://localhost:8080.

5. การทดสอบ API ด้วย Swagger UI
คุณสามารถทดสอบ API โดยเข้าไปที่ URL ต่อไปนี้ในเบราว์เซอร์ของคุณ:

bash
คัดลอก
แก้ไข
http://localhost:8080/apitest/swagger-ui.html
ที่นี่คุณจะสามารถทดสอบการทำงานของ API โดยการเลือก POST /apitest/gentoken และกรอกข้อมูลใน Request Body ตามตัวอย่างที่ให้ไว้ในเอกสาร.

API
POST /apitest/gentoken
API นี้รับข้อมูล SSOUserTest ในรูปแบบ JSON และบันทึกข้อมูลลงในฐานข้อมูล PostgreSQL:

Request Body ตัวอย่าง
json
คัดลอก
แก้ไข
{
  "ssoType": "SSOData",
  "systemId": "VATDEDEV",
  "systemName": "ระบบบันทึกข้อมูลภาษีมูลค่าเพิ่มทดสอบ)",
  "systemTransactions": "PRIV-010,PRIV-020,PRIV-040,PRIV-050",
  "systemPrivileges": "0|0|0|0",
  "systemUserGroup": "GRP-010,GRP-020,GRP-040",
  "systemLocationGroup": "CliC001",
  "userId": "WS233999",
  "userFullName": "ประสาท จันทร์อังคาร",
  "userRdOfficeCode": "01000999",
  "userOfficeCode": "01001139",
  "clientLocation": "01001139",
  "locationMachineNumber": "CLI00000718-9999",
  "tokenId": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9"
}
Response ตัวอย่าง
json
คัดลอก
แก้ไข
{
  "responseCode": "I07000",
  "responseMessage": "ทำรายการเรียบร้อย",
  "responseData": {
    "userId": "WS233200",
    "tokenId": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9..."
  }
}
การทดสอบ
โปรเจกต์นี้มีการทดสอบหน่วย (unit tests) ที่ใช้ JUnit สามารถรันการทดสอบทั้งหมดได้ด้วยคำสั่ง:

bash
คัดลอก
แก้ไข
mvn test
ข้อควรทราบ
Swagger UI ใช้สำหรับทดสอบ API ซึ่งจะช่วยให้การทดสอบเป็นไปอย่างรวดเร็วและเข้าใจง่าย
การเชื่อมต่อฐานข้อมูลต้องใช้ PostgreSQL และสร้างฐานข้อมูล ssotest ก่อน