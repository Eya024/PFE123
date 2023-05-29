interface Provider {
    id: number;
    userName: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    mobile: string;
    street: string;
    city: string;
    postcode: string;
    notifications: any[]; // You can replace `any` with a more specific type if needed
    roles: { id: number; name: string }[];
    workingPlan: {
      monday: { workingHours: { start: string; end: string } };
      tuesday: { workingHours: { start: string; end: string } };
      wednesday: { workingHours: { start: string; end: string } };
      thursday: { workingHours: { start: string; end: string } };
      friday: { workingHours: { start: string; end: string } };
      saturday: { workingHours: { start: string; end: string } };
      sunday: { workingHours: { start: string; end: string } };
    };
    banques: any[]; // You can replace `any` with a more specific type if needed
  }