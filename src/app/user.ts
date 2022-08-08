export class User{
    roles: string | undefined;
    userId(userId: any): string {
      throw new Error('Method not implemented.');
    }

    firstName!: String;
    lastName!: String;
    email!: String;
    
    constructor(
       _firstName:String,
       _lastName:String,
        _email:String
    ){}
    }
