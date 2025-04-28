namespace GroceryStore
{
    partial class ReceiptForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ReceiptForm));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.receiptPNL = new System.Windows.Forms.Panel();
            this.rcptLBL = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.receiptPNL.SuspendLayout();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(60, 4);
            this.pictureBox1.Margin = new System.Windows.Forms.Padding(2);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(41, 43);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 7;
            this.pictureBox1.TabStop = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.BlanchedAlmond;
            this.label1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.label1.Font = new System.Drawing.Font("Britannic Bold", 17.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Black;
            this.label1.Location = new System.Drawing.Point(109, 16);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(244, 26);
            this.label1.TabIndex = 8;
            this.label1.Text = "TINDAHAN DE ALKANSE";
            // 
            // receiptPNL
            // 
            this.receiptPNL.AutoSize = true;
            this.receiptPNL.BackColor = System.Drawing.Color.FloralWhite;
            this.receiptPNL.Controls.Add(this.rcptLBL);
            this.receiptPNL.Location = new System.Drawing.Point(25, 52);
            this.receiptPNL.Name = "receiptPNL";
            this.receiptPNL.Padding = new System.Windows.Forms.Padding(0, 0, 0, 10);
            this.receiptPNL.Size = new System.Drawing.Size(355, 379);
            this.receiptPNL.TabIndex = 9;
            this.receiptPNL.Paint += new System.Windows.Forms.PaintEventHandler(this.receiptPNL_Paint);
            // 
            // rcptLBL
            // 
            this.rcptLBL.AutoSize = true;
            this.rcptLBL.Dock = System.Windows.Forms.DockStyle.Top;
            this.rcptLBL.Font = new System.Drawing.Font("Courier New", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rcptLBL.Location = new System.Drawing.Point(0, 0);
            this.rcptLBL.Name = "rcptLBL";
            this.rcptLBL.Size = new System.Drawing.Size(56, 14);
            this.rcptLBL.TabIndex = 0;
            this.rcptLBL.Text = "receipt";
            this.rcptLBL.Click += new System.EventHandler(this.rcptLBL_Click);
            // 
            // ReceiptForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.DarkSeaGreen;
            this.ClientSize = new System.Drawing.Size(404, 455);
            this.Controls.Add(this.receiptPNL);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.pictureBox1);
            this.Name = "ReceiptForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "RECEIPT";
            this.Load += new System.EventHandler(this.ReceiptForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.receiptPNL.ResumeLayout(false);
            this.receiptPNL.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel receiptPNL;
        private System.Windows.Forms.Label rcptLBL;
    }
}