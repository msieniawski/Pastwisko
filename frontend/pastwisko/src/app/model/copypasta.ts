import {User} from "./user";
import {Comment} from "./comment";
import {Rating} from "./rating";
import {Tag} from "./tag";

export class Copypasta {
  title: String;
  text: String;
  creationDate: Date;
  author: User;
  comments: Comment[];
  ratings: Rating[];
  tags: Tag[];
}
