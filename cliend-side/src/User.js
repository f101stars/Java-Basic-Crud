import {useState ,useEffect} from "react";
import axios from "axios";
import AddAdv from "./AddAdv";


const User=({location} )=> {
  const [email, setEmail] = useState([]);
  const [password, setPassword] = useState([]);

  const [cover, setCover] = useState(true);
  const [cover2, setCover2] = useState(false);


let s
//   const fetchData = async () => {
//    s = await axios.post("http://localhost:3333/users/find",{
//         email,
//         password
//     });

//     if (s===false){
//       s = await axios.post("http://localhost:3333/users/add",{
//             email,
//             password
//         });
//     }
//     if(!s)
//     {
//         return <h1> סיסמא שגויה </h1>
//     }


// };

// useEffect(() => {
//   fetchData();
// }, []);


    // פונקציה המטפלת בשינויים בטופס
    const handleChange = (event) => {
        const { name, value } = event.target;
        switch (name) {
            case "email":
                setEmail(value);
                break;
            case "password":
                setPassword(value);
                break;
            default:
                break;
        }
    };



   // פונקציה המטפלת בשליחת הטופס
   const submitForm = async (event) => {
    event.preventDefault();

    try {
        // שליחת בקשת POST לשרת
         s = await axios.post("http://localhost:3333/users/find",{
            email,
            password
        });
    console.log(s);
        if (s.data===false){
          s = await axios.post("http://localhost:3333/users/add",{
                email,
                password
            });
        }
        if(!s.data)
        {
          alert("סיסמה שגויה")
        }
    
else{
        setCover(false)
    setCover2(true)
}



    } catch (error) {
        console.error(error);
    }
};  
return (
  
    <div className="imgList">
       {cover&&  <form onSubmit={submitForm} className={cover? "form":"aaa"}>


<input
    value={email}
    placeholder="נא להכניס מייל   "
    required
    name="email"
    onChange={handleChange}
/>
<input
    value={password}
    placeholder="נא להכניס סיסמא   "
    required
    name="password"
    onChange={handleChange}
/>
{/* כפתור לשליחת הטופס */}
<button type="submit">
    שלח
</button>

</form>
}
{cover2 && <AddAdv location={location}  email={email}/> }
        </div>
);
}

export default User;
