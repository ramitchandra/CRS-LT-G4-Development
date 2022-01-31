export class Course {

    // need to create the properties 
    
        public courseId:number;
        public courseName : string;
        public courseAvailable : boolean;
        public offlineFees : number;
        public onlineFees : number;
    
        constructor(courseId:number,courseName:string, courseAvailable: boolean,offlineFees:number,onlineFees:number){
            this.courseId = courseId,
            this.courseName = courseName;
            this.courseAvailable = courseAvailable;
            this.offlineFees = offlineFees;
            this.onlineFees = onlineFees;
        }
        // constructor( courseId: number,
        //     courseName : string,
        //     courseAvailable : boolean,
        //     offlineAmount : number,
        //     onlineAmount : number
        // ){}
}
    
    
  