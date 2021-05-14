import firebase from 'firebase';
const config = {
    apiKey: "AIzaSyDsM_4ThepWEHAClUPBYSu3R2MqDXNW3vk",
    authDomain: "jsw-internship.firebaseapp.com",
    databaseURL: "https://jsw-internship-default-rtdb.firebaseio.com/",
    projectId: "jsw-internship",
    storageBucket: "jsw-internship.appspot.com",
    messagingSenderId: "00000000000",
    appId: "1:341874131477:android:322207270dbe662005041c",
    measurementId: "1111111111"
  
};
firebase.initializeApp(config);
export default firebase;