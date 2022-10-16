import React from "react";

// Import components
import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

import "../css/pages/UniversitiesPage.css";

const UniversitiesPage = () =>{

    return (
        <>
            <Sidebar/>
            <div className="page-wrap">
                <Header/>
                <div className="page-content">
                    <h2>Universidades</h2>

                    <div className="uni-menu">
                        <div className="uni-menu-content">
                            <div className="uni-menu-item">Estatísticas gerais</div>
                            <div className="uni-menu-item">ENEM</div>
                            <div className="uni-menu-item">UFABC</div>
                            <div className="uni-menu-item">USP</div>
                            <div className="uni-menu-item">UFSCAR</div>
                            <div className="uni-menu-item">UNICAMP</div>
                            <div className="uni-menu-item">IFSP</div>
                            <div className="uni-menu-item">UNESP</div>
                            <div className="uni-menu-item">UNIFESP</div>
                            <div className="uni-menu-item">ITA</div>
                        </div>
                    </div>

                    <div>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eu rutrum nisi. Maecenas nisi ligula, dapibus et lorem ut, luctus rutrum sapien. Donec consectetur fermentum lorem, non rutrum tortor ullamcorper sed. Integer scelerisque urna et lorem vulputate commodo. Aliquam pulvinar arcu a tellus posuere tempor. Donec sit amet fermentum justo. Fusce pellentesque a purus quis iaculis. In venenatis ante ac lectus posuere, et scelerisque ipsum ultrices. Phasellus mollis eget magna vel porta. Pellentesque tincidunt massa non dui lacinia imperdiet. Praesent porta mattis ornare. Quisque ultricies magna luctus justo venenatis, varius ullamcorper mi ultrices. Aliquam varius at lorem ac tristique.
                    Sed et dui nunc. Donec porta diam nibh, sit amet suscipit libero mattis vel. Mauris luctus lorem non nunc tristique elementum. Nunc malesuada, quam ut varius mollis, risus ex bibendum lorem, a tempor tortor risus sed libero. Sed sit amet purus turpis. Etiam cursus nisl eros, eget blandit lectus fringilla sit amet. Pellentesque mollis diam at purus venenatis dapibus. Etiam tincidunt venenatis fringilla. Nunc risus ipsum, tristique eget nulla quis, porttitor elementum tellus. In aliquet consectetur arcu quis posuere. Praesent ante dui, elementum et orci sodales, pellentesque varius lorem.
                    Quisque augue urna, vulputate vel ex id, molestie faucibus orci. Donec vulputate condimentum sem. Ut massa velit, posuere sed sollicitudin quis, rutrum et dui. Pellentesque eleifend feugiat sem non sollicitudin. Etiam ac enim vel erat mollis scelerisque vitae et sapien. Aliquam porttitor rutrum ex, et laoreet urna. Suspendisse potenti. Aliquam at urna vel ipsum pharetra vestibulum. Nullam vel turpis nisi. Duis iaculis est arcu, vitae feugiat libero aliquam vitae. Curabitur venenatis imperdiet dignissim. Pellentesque nec sapien quis dolor tempor placerat. Proin fermentum egestas pretium. Nullam eleifend hendrerit nisi ut interdum. Aenean sed varius est.
                    </div>

                </div>
            </div>
        </>
    )
}

export default UniversitiesPage;