# gp-graphql-service

graphql service with datafetcher method , all crud operations , pagnation and junit classes.

Primary link :
https://dzone.com/articles/a-beginners-guide-to-graphql-with-spring-boot 

Secondary links :
https://graphql.org/ 
https://dimitr.im/graphql-mutations-spring 

postman url with post type:
http://localhost:8080/argentina/gpservice

http://localhost:9090/swagger-ui.html

{
allAccounts(skip:2,first:5){id acctId acctName amount bankDetails{bankId bankName branchCode}
contacts{contactNumber email}
addressDetails{addressLine1 addressLine2 city state country zip landmark}
amount accountType status
audit{createdBy createdDate modifiedBy modifiedDate}
}
}

{
account(acctId: "CITI62199")
{id acctId acctName amount bankDetails{bankId bankName ifsc branchCode}
contacts{contactNumber email}
addressDetails{addressLine1 addressLine2 city state country zip landmark}
amount accountType status
audit{createdBy createdDate modifiedBy modifiedDate}
}
}

{
"acctName": "Rohit Sinha",
"amount": "600",
"accountType": "current",
"status": "active",
"bankDetails":{	"bankId": 123,"bankName": "ICICI","ifsc": "ICIC0001","branchCode": "CODE1"},
"contacts":{"contactNumber": "723891421", "email":"xyz@gmail.com"},
"addressDetails":{"addressLine1": "address1", "addressLine2":"address2", "city":"mumbai", "state": "maharastra", "country":"India", "zip":"400134", "landmark":"ram mandir"},
"audit":{"createdBy":"Manish", "createdDate":"2020-04-03", "modifiedBy":"Shri", "modifiedDate":"2020-04-05"}
}

{
"acctId": "CITI23339",
"acctName": "Rohit",
"amount": "600",
"accountType": "current",
"status": "active",
"bankDetails":{	"bankId": 123,"bankName": "ICICI","ifsc": "ICIC0001","branchCode": "CODE1"},
"contacts":{"contactNumber": "723891421", "email":"xyz@gmail.com"},
"addressDetails":{"addressLine1": "address1", "addressLine2":"address2", "city":"mumbai", "state": "maharastra", "country":"India", "zip":"400134", "landmark":"ram mandir"},
"audit":{"createdBy":"Manish", "createdDate":"2020-04-03", "modifiedBy":"Shri", "modifiedDate":"2020-04-05"}
}





http://localhost:9090/api/v1/graphql



{
allAccounts(skip:2,first:5){id acctId acctName amount bankDetails{bankId bankName ifsc branchCode}
contacts{contactNumber email}
addressDetails{addressLine1 addressLine2 city state country zip landmark}
amount accountType status
audit{createdBy createdDate modifiedBy modifiedDate}
}
}

{
account(acctId: "CITI63138")
{id acctId acctName amount bankDetails{bankId bankName ifsc branchCode}
contacts{contactNumber email}
addressDetails{addressLine1 addressLine2 city state country zip landmark}
amount accountType status
audit{createdBy createdDate modifiedBy modifiedDate}
}
}

mutation { 
  createAccount(acctName: "Pooja Agarwal", amount: 600, accountType: "current", status: "active",
  bankDetails:{bankId: 123, bankName: "ICICI", ifsc: "ICIC0001",branchCode: "CODE1"},
  contacts:{contactNumber: "723891421", email:"xyz@gmail.com"},
 addressDetails:{addressLine1: "address1", addressLine2:"address2", city:"mumbai", state: "maharastra", country:"India", zip:400134, landmark:"ram mandir"},
  audit:{createdBy:"Nalini",createdDate:"2020-04-03",modifiedBy:"Shri", modifiedDate:"2020-04-05"})  
  { 
    id acctName audit{createdBy createdDate modifiedBy modifiedDate}
  } 
} 


mutation{
updateAccount(acctId: "CITI64806", acctName: "Rohit Sinha", amount: 600, accountType: "current", status: "active",
  bankDetails:{bankId: 123, bankName: "ICICI", ifsc: "ICIC0001",branchCode: "CODE1"},
  contacts:{contactNumber: "723891421", email:"xyz@gmail.com"},
 addressDetails:{addressLine1: "address1", addressLine2:"address2", city:"mumbai", state: "maharastra", country:"India", zip:400134, landmark:"ram mandir"},
  audit:{createdBy:"Pooja Agarwal",createdDate:"2020-04-03",modifiedBy:"Shri", modifiedDate:"2020-04-05"})
{ 
    id 
  }
}

mutation{
deleteAccount(acctId: "CITI74549")
{ 
    id 
  }
}

http://localhost:9090/api/v1/grahql

