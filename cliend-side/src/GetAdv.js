import {useState ,useEffect} from "react";
import Axios from "axios";


const GetAdv=()=> {
  const [imgs, setImgs] = useState([]);


  const fetchData = async () => {
    const { data } = await Axios.get("http://localhost:3333/adv/entrance");
    setImgs(data);
    console.log(data);
};

useEffect(() => {
  fetchData();
}, []);

if (imgs.length === 0) return( <div className="empty">
<h1>no imgs here</h1>

</div>)
return (
  
    <div className="imgList">

            {imgs.map((img) => (
                <div>
                    
                 {img.img}
                </div>
            ))}
        </div>
);
}

export default GetAdv;
