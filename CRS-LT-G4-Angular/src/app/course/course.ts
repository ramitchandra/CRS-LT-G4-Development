export class Course {

    // need to create the properties 
    
        public courseId:number;
        public courseName : string;
        public courseAvailable : boolean;
        public offlineAmount : number;
        public onlineAmount : number;
    
        constructor(courseId:number,courseName:string, courseAvailable: boolean,offlineAmount:number,onlineAmount:number){
            this.courseId = courseId,
            this.courseName = courseName;
            this.courseAvailable = courseAvailable;
            this.offlineAmount = offlineAmount;
            this.onlineAmount = onlineAmount;
        }
    
    
    }