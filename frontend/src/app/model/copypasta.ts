import {Comment} from "./comment";
import {Rating} from "./rating";
import {Tag} from "./tag";

export class Copypasta {
  id: number;
  title: string;
  text: string;
  creationDate: Date;
  author: string;
  comments: Comment[];
  ratings: Rating[];
  tags: Tag[];
}
