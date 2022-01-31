export class Professor {

    //  create the professor properties 
    
        public professorId : number;
        public professorName : string;
        public professorPassword : string;
    
        constructor(professorId:number,professorName:string, professorPassword: string){

            this.professorId = professorId,
            this.professorName = professorName;
            this.professorPassword = professorPassword;

        }
    
    }